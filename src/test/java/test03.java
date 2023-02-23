
import base.url.university.domain.UniversityDomainList;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class test03 extends UniversityDomainList {

    @Test
    public void get(){

        //1st -Set the url and get response

        Response response = given().when().get(endpoint2);

        response.prettyPrint();

        // 2nd-set the expected data

        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("country", "Turkey");

        //check if code works successfully

        given().then().statusCode(200);

        Assert.assertEquals(response.statusCode(),200);

        //check if content type is json

        System.out.println(response.getContentType());

        Assert.assertEquals(response.getContentType(),"application/json");

        System.out.println(response.getHeader("content-type"));

        // Validate that if the list contains Turkey

        JsonPath json = response.jsonPath();

        List<String> list = json.getList("country");

        System.out.println("This is the list :"+ list);

        Assert.assertTrue(list.contains(expectedData.get("country")));

        //check if it is only contains Turkey

        Assert.assertEquals(list.size(),1);
    }


    }

