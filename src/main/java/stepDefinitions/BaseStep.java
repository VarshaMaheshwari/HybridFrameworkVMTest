package stepDefinitions;

import com.mongodb.util.JSON;
import constants.ConfigConstants;
import commons.ScenarioContext;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class BaseStep {
    String baseUrl="https://weatherbit-v1-mashape.p.rapidapi.com/";
    //https://www.toolsqa.com/rest-assured/share-scenario-context/

    protected static final int SUCCESS = 200;
    protected static final int CREATED = 201;
    protected static final int INTERNAL_SERVER_ERROR = 500;
    /**
     * Restassured response.
     */
    protected Response response;
    /**
     * Restassured request.
     */
    protected RequestSpecification request;

    protected ScenarioContext scenarioContext = new ScenarioContext();
    // Logger log = LoggerFactory.getLogger(this.getClass().getName());

    protected Logger logger = Logger.getLogger(this.getClass().getName());
    protected static final String BASE_GW_URL = "v1/autoscript-gateway/";

    public void initPortForwarding(String url, String kubeCtlCmd) {
        int counter = 0;
        while (counter < 3) {
            if (isUrlReachable(url)) {
                // do nothing
                logger.info(url + " is reachable!!!");
                break;
            } else { // start port forwarding
                logger.info(url + " is not reachable!!!");
                logger.info("Start port forwarding for => [" + url + "]");
                try {
                    logger.info("kubeCtlCmd");
                    Process proc = Runtime.getRuntime().exec(kubeCtlCmd);
                    BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        logger.info(e.getMessage());
                    }
                } catch (Exception e) {
                    logger.info(e.getMessage());
                }
            }
            counter++;
        }
    }

    private boolean isUrlReachable(String url) {
        request = given().baseUri(url);
        try {
            response = request.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected RequestSpecification authenticationMethod(RequestSpecification request, CommonRequestDto dto) {
        if (StringUtils.isNotEmpty(dto.getApplication())) {
            if (dto.getApplication().equalsIgnoreCase(CommonConstants.ApplicationTest)) {
                if (StringUtils.isEmpty(dto.getTokenType())) {
                    request.auth().oauth2(ConfigConstants.accessToken);
                } else {
                    request.auth().oauth2(ConfigConstants.getAccessTokenExpired());
                }
            }
           }

        }
        else if (StringUtils.isNotEmpty(dto.getUserName()) && StringUtils.isNotEmpty(dto.getPassword())) {
            request.auth().preemptive().basic(dto.getUserName().trim(), dto.getPassword().trim());
        } else if (StringUtils.isNotEmpty(ConfigConstants.getTestUsername()) && StringUtils.isNotEmpty(ConfigConstants.getTestPassword()))  {
            request.auth().preemptive().basic(ConfigConstants.getTestUsername(),ConfigConstants.getTestPassword());
        }

        return request;
    }

    public static RequestSpecification given() {
        return RestAssured.given()
                .config(RestAssured.config().objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));
    }

    protected Map<String, Object> getHeaders(String dataType) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(DataType.value(), dataType);
        headers.put(ContentType.value(), JSON.value());
        return headers;
    }

}
