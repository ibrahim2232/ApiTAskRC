import base.url.university.domain.UniversityDomainList;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;

public class test01 extends UniversityDomainList {

    @Test
    public void get() {

        //1st -Set the url and get response

        Response response = given().when().get(endpoint);

        given().then().statusCode(200);

        Assert.assertEquals(response.statusCode(), 200);

       // response.prettyPrint();

        JsonPath json = response.jsonPath();

        List<String> list = json.getList("name");

       System.out.println(list);

       for(int i=0;i<list.size();i++){

         if (list.get(i).contains("Middle")){

             System.out.println("The test is succesfull");
         }else{
             System.out.println("The test is not succesfull");
         }


        }

        }

    }
