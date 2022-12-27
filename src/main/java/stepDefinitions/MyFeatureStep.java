package stepDefinitions;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Description;
import org.testng.Assert;
import org.hamcrest.Matchers.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.*;

public class MyFeatureStep extends BaseStep {
    //IMP link to refer-- https://github.com/rest-assured/rest-assured/wiki/Usage#example-1---json
    String apiurl = baseUrl + "forecast/3hourly";
    HashMap<String, String> headersMap = new HashMap<String, String>();
    HashMap<String, String> paramsMap = new HashMap<String, String>();

    @Given("I have api payload")
    public void i_have_api_payload() {
        headersMap.put("X-RapidAPI-Key", "83e8a706d2msh1d66312f87521bap1c8c0djsn39c7ce1de760");
        headersMap.put("X-RapidAPI-Host", "weatherbit-v1-mashape.p.rapidapi.com");
        paramsMap.put("lat", "35.5");
        paramsMap.put("lon", "-78.5");
        RequestSpecification request = given().headers(headersMap).params(paramsMap);
        //header method takes 1 header at a time
/*        request.header("X-RapidAPI-Key","83e8a706d2msh1d66312f87521bap1c8c0djsn39c7ce1de760");
        request.header("X-RapidAPI-Host","weatherbit-v1-mashape.p.rapidapi.com");*/

//        Response response =request.log().all().
//                when().get(apiurl);
        Response response = request.log().all().when().get(apiurl);
        response.prettyPrint();

   /*     Assert that use with hamcrest matchers methods
        request.log().all().when().get(apiurl).then().assertThat().body("city_name",equalTo("Four 1Oaks"));
        request.log().all().when().get(apiurl).then().assertThat().body("data.pod",hasItems("d","n")).log().all();
           response.prettyPrint().equals(200);*/
        Long responseTime = response.timeIn(SECONDS);
        System.out.println(responseTime + ": responseTime");
        //Validating response through Groovy gpath
        String responseBody = response.getBody().asString();
        List<String> testlist = from(responseBody).getList("data.weather.findAll { it.code =804 }.description");
        for (String s : testlist
        ) {
            System.out.println("Description :" + s);
            System.out.println();
        }

        //JSONPath use for validating response
        Assert.assertTrue(responseBody.contains("\"America/New_York\""));
        //Assert.assertTrue( response.jsonPath().getString("data[20].pod").equals("d"));

        //JsonPath
        JsonPath jsonPath = new JsonPath(responseBody);
        System.out.println(jsonPath.get("data[0].weather.icon"));
    }

    @When("I do get api call")
    public void i_do_get_api_call() {
        System.out.println("This is when step");
    }

    @Then("I get valid api response code and responsebody")
    public void i_get_valid_api_response_code_and_responsebody() {
        System.out.println("This is Then step");
    }

    @Given("I have user and password for login")
    public void i_have_user_and_password_for_login(io.cucumber.datatable.DataTable dataTable) {
        /*List<List<String>> listOfcreds = dataTable.asLists();

        for (List<String> str : listOfcreds) {
            System.out.println(str);
        }*/

        List<Map<String, String>> list=dataTable.asMaps();

        for(Map<String, String> strMap:list){
            System.out.println(strMap.entrySet());
        }


    }

}
