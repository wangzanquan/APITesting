package com.APIAssured.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GET_Request_Validating_Headers {

    @Test
    void googleMapTest(){
        //Specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET,"/videogames");

        //Print response in console window
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,500);

        //Status line verification
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 500 ");


    }
}
