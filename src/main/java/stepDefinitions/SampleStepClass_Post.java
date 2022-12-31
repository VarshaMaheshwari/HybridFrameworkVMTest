package stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import constants.ApisConstants;
import constants.ConfigConstants;
import commons.ScenarioContext;
import dtos.DTOsample;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.testng.Assert;
import utils.ByteArrayConverterUtil;
import utils.JsonUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class SampleStepClass_Post extends BaseStep {

        private String baseUrl = ConfigConstants.getBaseurl();
        private String endpoint = baseUrl + "/requests";
        public String fileName;
        public String payLoad;
        String actualMessage;
        public String locationHeader;
        public Response finalResponse;
        private JsonPath js;
        private int DataCount;
        RequestSpecification getAPIRequest = null;
        String href = null;
        String requestStatus = null;
       // private DaoUtility daoUtility = new DaoUtility();

//        List<SampleSqlModel> ProcessorJobDataList;
//        List<String> ResponsedataList;
//        List<String> ResponseDataUIDList;
//        List<String> tableList;
//        List<String> DataTableDataUIDList;

        public SampleStepClass_Post(ScenarioContext context) {
            scenarioContext = context;
        }

        /**
         * Reading Json file using JsonUtility class
         *
         * @param dtos
         * @throws IOException
         */
        @Given("^Employee data exists$")
        public void employee_Processor_data(List<Map<String, String>> dtList)throws IOException {
            List<DTOsample> dtos = new ArrayList<>();
            for (Map<String, String> dtMap : dtList) {
                dtos.add(DTOsample.convertToDtos(dtMap));
            }
            for (DTOsample dto : dtos) {
                if (StringUtils.isNotEmpty(dto.getFileName())) {
                    fileName = dto.getFileName().trim();
                }
            }
            payLoad = JsonUtility.jsonFileReader(fileName);
            scenarioContext.setContext(ApisConstants.RequestPayload, payLoad);
        }

        /**
         * @param dtos Hitting end point and storing response into scenarioContexts
         */
        @When("^I upload list of test records for processing$")
        public void postProcessorDetails(List<Map<String, String>> dtList)throws Exception {
            List<DTOsample> dtos = new ArrayList<>();
            for (Map<String, String> dtMap : dtList) {
                dtos.add(DTOsample.convertToDtos(dtMap));
            }
            List<Response> responses = new ArrayList<>();
            request = constructProcessorRequestBody(dtos);
            request.body(payLoad);
            Response response = request.when().log().all().post(endpoint);
            System.out.println("Statuscode: " + response.getStatusCode());
            responses.add(response);
            // storing response object into scenarioContext
            scenarioContext.setContext(ApisConstants.SampleResponses, responses);
        }

        /**
         *
         * @param dtos
         */
        @Then("^Validate processor response$")
        public void validateResponse(List<Map<String, String>> dtList)throws Exception {
            List<DTOsample> dtos = new ArrayList<>();
            for (Map<String, String> dtMap : dtList) {
                dtos.add(DTOsample.convertToDtos(dtMap);
            }
            // retrieving response object from scenarioContext
            List<Response> responses = (List<Response>) (scenarioContext
                    .getContext(ApisConstants.SampleResponses));
            for (int i = 0; i < responses.size(); i++) {
                Assert.assertEquals(String.valueOf(responses.get(i).getStatusCode()), dtos.get(i).getHttpStatusCode(),
                        "Mismatch of status code.");
                if (!dtos.get(i).getMessage().isEmpty()) {
                    actualMessage = responses.get(i).jsonPath().get("message");
                    Assert.assertEquals(actualMessage, dtos.get(i).getMessage());
                }
            }

        }

        @Then("^I search Processor final response with requestId till status complete$")
        public void searchProcessorFinalResponseWithRequestIdTillStatusComplete(List<Map<String, String>> dtList)throws Exception {
            List<DTOsample> dtos = new ArrayList<>();
            for (Map<String, String> dtMap : dtList) {
                dtos.add(DTOsample.convertToDtos(dtMap));
            }
            List<Response> responses = (List<Response>) (scenarioContext
                    .getContext(ApisConstants.ProcessorListProcessorResponses));
            /*
             * Captured the "Location" header from the Processor list processor API response
             * header
             */
            for (int i = 0; i < responses.size(); i++) {
                locationHeader = responses.get(i).getHeader("Location");
            }
            getAPIRequest = authenticationMethod(given(), dtos.get(0));
            System.out.println("calling locationheader href:" + locationHeader);
            finalResponse = getAPIRequest.when().log().all().get(locationHeader);
            for (DTOsample dto : dtos) {
                long startTime =System.currentTimeMillis();
                while (!"COMPLETE".equals(finalResponse.jsonPath().get("requestStatus"))) {

                    Thread.sleep(dto.getIdleTime() * 1000L);
                    finalResponse = authenticationMethod(given(), dtos.get(0)).when().log().all().get(getHref());
                    requestStatus = finalResponse.jsonPath().get("requestStatus");
                    System.out.println(requestStatus);
                    if ((System.currentTimeMillis() - startTime) > (dto.getIdleTime() * 60000L))
                    {
                        break;
                    }

                }
            }

            ProcessorResponse ProcessorResponse = new ObjectMapper().readValue(finalResponse.getBody().asString(),
                    ProcessorResponse.class);
            String unzippedResponse = ByteArrayConverterUtil.byteArrayConverter(ProcessorResponse);
            System.out.println("unZipped final response:" + unzippedResponse);
            scenarioContext.setContext(ApisConstants.FinalResponse, unzippedResponse);
        }

        private String getHref() {
            return finalResponse.jsonPath().get("href");
        }

        @Then("^validate response$")
        public void validateProcessorStudiesResponse(List<Map<String, String>> dtList)throws Exception {
            List<CommonResponseDto> dtos = new ArrayList<>();
            for (Map<String, String> dtMap : dtList) {
                dtos.add(convertToDtosResponse(dtMap));
            }
            String unZippedResponse = (String) (scenarioContext.getContext(ApisConstants.ProcessorListFinalResponse));
            List<SampleSqlModel> ProcessorJobDBData = (List<SampleSqlModel>) scenarioContext
                    .getContext(DatabaseApisConstants.ProcessorJOB_DATA);

            JSONArray responseArray = new JSONArray(unZippedResponse);
            ResponsedataList = new ArrayList<String>();
            ResponseDataUIDList = new ArrayList<String>();
            tableList = new ArrayList<String>();
            DataTableDataUIDList = new ArrayList<String>();
            if (responseArray.length() > 0) {
                for (int k = 0; k < responseArray.length(); k++) {
                    js = new JsonPath(responseArray.getJSONObject(k).toString());

                    if (StringUtils.isNotEmpty(ProcessorJobDBData.get(k).getProcessorID())) {
                        Assert.assertEquals(js.getString("Processor.ProcessorId"),
                                ProcessorJobDBData.get(k).getProcessorID());
                    }


                    List<String> ProcessorJobIdList = (List<String>) scenarioContext
                            .getContext(DatabaseApisConstants.ProcessorLISTPROCESSOR_JOBID);
                    for (String ProcessorJobId : ProcessorJobIdList) {
                        ProcessorList = daoUtility.getProcessorDataSqlDao()
                                .selectProcessorDataDetails(Integer.parseInt(ProcessorJobId));
                        for (int j = 0; j < ProcessorList.size(); j++) {
                            tableList.add(ProcessorJobDataList.get(j).getdata());
                            tableList.add(ProcessorJobDataList.get(j).getDataUid());
                        }
                    }
          
                }

            }

            else
                System.out.println("final response is null or empty:" + unZippedResponse);
        }


        /**
         * Construct method to add headers & pathParams to request object
         *
         * @param dtos
         * @return
         */
        private RequestSpecification constructProcessorRequestBody(List<DTOsample> dtos) {
            request = given();
            for (DTOsample dto : dtos) {
                request = authenticationMethod(request, dto);
                if (StringUtils.isNotEmpty(dto.getCode())) {
                    request.pathParam("Code", dto.getCode());
                }
                if (StringUtils.isNotEmpty(dto.getContentType())) {
                    request.header("Content-Type", dto.getContentType().trim());
                }
            }
            return request;
        }

    }

}
