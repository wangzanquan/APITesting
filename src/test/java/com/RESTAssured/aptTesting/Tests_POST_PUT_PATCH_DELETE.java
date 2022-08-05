package com.RESTAssured.aptTesting;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class Tests_POST_PUT_PATCH_DELETE {

    @Test(description = "POST")
    public void test_1_post(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Tony");
        map.put("job", "Tester");

        //Using Json simple convert
        JSONObject request = new JSONObject(map);

        //another way
        request.put("name", "Tony2");
        request.put("job", "Tester");

        System.out.println(request);

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .post("https://reqres.in/api/users")
         .then()
                .statusCode(201);
    }

    @Test(description = "PUT")
    public void test_2_put(){
        //Using Json simple convert
        JSONObject request = new JSONObject();

        //another way
        request.put("name", "Tony2");
        request.put("job", "Tester");

        System.out.println(request);

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .put("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test(description = "PATCH")
    public void test_3_patch(){
        //Using Json simple convert
        JSONObject request = new JSONObject();

        //another way
        request.put("name", "Tony2");
        request.put("job", "Tester");

        System.out.println(request);

        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .patch("https://reqres.in/api/users/2")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test(description = "DELETE")
    public void test_4_delete(){


        when()
                .delete("https://reqres.in/api/users/2")
        .then()
                .statusCode(204)
                .log().all();
    }

}
