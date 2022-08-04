package com.APIAssured.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

public class TC002_POST_Request {

    @Test
    void RegistrationSuccessful() throws IllegalAccessException, NoSuchFieldException, IOException {
        System.setProperty("file.encoding","UTF-8");

        //Specify base URI
        RestAssured.baseURI = "http://localhost:8080/app";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request payload sending along with post request
        JSONObject requestParams = new JSONObject();


        requestParams.put("id", 3);
        requestParams.put("name", "string");
        requestParams.put("releaseDate", "2022-08-04T06:47:43.612Z");
        requestParams.put("reviewScore", 0);
        requestParams.put("category", "string");
        requestParams.put("rating", "string");

        //httpRequest.headers("Content-Type", "application/jason");

        httpRequest.body(requestParams.toJSONString());

        //Response object
        Response response = httpRequest.request(Method.POST,"/videogames");


        //Print response in console window
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,400);

        String errorCode = response.jsonPath().get("error");
        System.out.println(errorCode);




    }

}
