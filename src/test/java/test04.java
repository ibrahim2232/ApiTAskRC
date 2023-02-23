
import base.url.university.domain.UniversityDomainList;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class test04 extends UniversityDomainList {

    @Test
    public void get() {

        //1st -Set the url and get response

        Response response = given().when().get(endpoint);

       // response.prettyPrint();

        // 2nd-set the expected data

        Map<String, Object> expectedDataCountry = new HashMap<>();

        expectedDataCountry.put("country", "United States");

        Map<String, Object> expectedDataUniversity = new HashMap<>();

        expectedDataUniversity.put("name1", "Middle Tennessee State University");
        expectedDataUniversity.put("name2", "Middle Georgia State College");
        expectedDataUniversity.put("name3", "Middlebury College");


        //check if code works successfully

        given().then().statusCode(200);

        Assert.assertEquals(response.statusCode(),200);

        //check if content type is json

        System.out.println(response.getContentType());

        Assert.assertEquals(response.getContentType(),"application/json");

        System.out.println(response.getHeader("content-type"));

        // Validate that if the list contains United States

        JsonPath json = response.jsonPath();

        List<String> list = json.getList("country");
        List<String> list2 = json.getList("name");

        System.out.println("This is the list :"+ list);

        Assert.assertTrue(list.contains(expectedDataCountry.get("country")));

        // Validate that if the list contains selected Universities

        System.out.println(list2);
        Assert.assertTrue(list2.contains(expectedDataUniversity.get("name1")));
        Assert.assertTrue(list2.contains(expectedDataUniversity.get("name2")));
        Assert.assertTrue(list2.contains(expectedDataUniversity.get("name3")));

    }
}

    
