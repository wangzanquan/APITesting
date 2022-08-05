package com.RESTAssured.aptTesting;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Examples {

    @Test
    public void test_get(){

        baseURI = "http://localhost:3000/";

        given().
                //this param same function as "http://localhost:3000/subjects/name?Automation
                param("name", "Automation").
                get("/subjects").
        then().
                statusCode(200).log().all();

    }

    @Test
    public void test_post(){
        baseURI = "http://localhost:3000/";

        JSONObject request = new JSONObject();

        request.put("firstName", "Zan");
        request.put("lastName", "Wang");
        request.put("subjectID", 1);

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

    @Test
    public void test_patch(){
        baseURI = "http://localhost:3000/";

        JSONObject request = new JSONObject();


        request.put("lastName", "Wang2");


        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when().
                patch("/users/4").
        then().
                statusCode((200)).
                log().all();

    }

    @Test
    public void test_put(){
        baseURI = "http://localhost:3000/";

        JSONObject request = new JSONObject();


        request.put("firstName", "Mary");
        request.put("lastName", "Jhin");
        request.put("subjectID", 1);


        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
        when().
                put("/users/4").
        then().
                statusCode((200)).
                log().all();

    }

    @Test
    public void test_delete(){
        baseURI = "http://localhost:3000/";

        when().
                delete("/users/4").
        then().
                statusCode(200);

    }



}
