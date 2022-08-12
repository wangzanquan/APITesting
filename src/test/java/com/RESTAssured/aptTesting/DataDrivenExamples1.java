package com.RESTAssured.aptTesting;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples1 extends DataForTests{

    /*
    TestNG DataProvider
        - Helps to write data riven tests
        - Same test can be run multiple times with diff sets of data
        - Annotation @DataProvider
        - The annotated method is used to return object containing test data
        - This test data can be used in actual tests
     */

/*    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost(){
        //Hard coding data
//        Object[][] data = new Object[2][3];
//
//        data[0][0] = "Albert";
//        data[0][1] = "Eistein";
//        data[0][2] = 2;
//
//        data[1][0] = "Thomas";
//        data[1][1] = "Edison";
//        data[1][2] = 1;
//
//        return data;

        return new Object[][] {
                {"Graham", "Bell", 1},
                {"Henry", "Ford", 2}
        };

    }*/

    @Test(dataProvider = "DataForPost")
    public void test_post(String fristName, String lastName, int subjectId){
        baseURI = "http://localhost:3000/";

        JSONObject request = new JSONObject();

        request.put("firstName", fristName);
        request.put("lastName", lastName);
        request.put("subjectID", subjectId);

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode((201)).
                log().all();

    }

/*    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){

        return new Object[]{
                4,5,6,7
        };
    }*/

    @Parameters({"userId"})
    @Test
    public void test_delete2(int userId){
        System.out.println("Value for userId is: " + userId);
        baseURI = "http://localhost:3000/";

        when().
                delete("/users/" + userId).
        then().
                statusCode(200);

    }


}
