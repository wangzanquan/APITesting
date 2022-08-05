package com.RESTAssured.aptTesting;

//Using static that can use RestAssured as an object
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Test01_GET {

    @Test
    void test_01(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println("=========================");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("=========================");
        System.out.println(response.getStatusCode());
        System.out.println("=========================");
        System.out.println(response.getStatusLine());
        System.out.println("=========================");
        System.out.println(response.getHeader("content-type"));
        System.out.println("=========================");
        System.out.println(response.getContentType());
        System.out.println("=========================");
        System.out.println(response.getTime());

    }

    @Test
    void test_02(){
        /*
        get() the endpoint of the uri
         */
        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200)
                .body("data.id[0]",equalTo(7));

    }


}
