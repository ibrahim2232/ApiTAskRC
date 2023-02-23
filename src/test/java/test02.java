import base.url.university.domain.UniversityDomainList;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;


public class test02 extends UniversityDomainList {

    @Test
    public void get() {

        //1st -Set the url and get response

        Response response = RestAssured.get(endpoint);

       // 2nd-set the expected data

        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("name", "Middle East Technical University");

        //check if code works successfully

        given().then().statusCode(200);

        Assert.assertEquals(response.statusCode(),200);

        //check if content type is json

        System.out.println(response.getContentType());

        Assert.assertEquals(response.getContentType(),"application/json");

        System.out.println(response.getHeader("content-type"));

        // Validate that if the Middle East Technical University is in the response list

        JsonPath json = response.jsonPath();

       List<String> list = json.getList("name");

       System.out.println("This is the list :"+ list);

       Assert.assertTrue(list.contains(expectedData.get("name")));

    }

}
