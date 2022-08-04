package com.test.api;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
/*
Rest Assured is a java library that we use to work with apis
    A Framework

We also use Ham Crest Matchers to perform in level api basic testing.
 */

public class Demo {

    /*
    https://www.guru99.com/rest-assured.html
    API's

    Topics: Methods
        Get, Post, Put, Delete

        Parameters and Query Parameters

        Use case for it and testing types


    What does the api methods do:
        "Create, Replace, Update, Delete" methods are used to update the API
        - API: is an application interface that communicates between the Website and the Database
            - It tracks or implements users actions between a server / or database and website
                -Sign up info
                -Tracks History
                -Cookies, Passwords, and other user actions that need to be done or saved.


     */

    /*
    BaseURI - it is the main link to the api or api page.
    Base URI we perform our operations based on the resource
    https://www.google.com/apis
     */


    /*
    we can either place it in a static method or inside each individual test method

    static{
        baseURI = "";
    }

    In API we need to verify 4 components:
        -Correct HTTP status codes: such as 200, 400, 500.
            -200s means ok or success
            -400s means user errors
            -50s are server errors or failures
     */

    @Test
    public void getResources(){
        //GET: is used to retrive or look at the api's saved information
        baseURI = "https://gorest.co.in/public/v2/users";

        /*
        Rest Assured uses GHERKIN language such as Given, When and Then

        given() - we pass path parameter, query, headers, body, keys, etc...

        when() - is used for performing a request or response
                - inside the get() we place a endpoint or the end destination


        We need to verify the response payload
            --Checking JSON body for information

        - Response Headers
            -- These are used to send password, keys, accepting formats, etc...

        - Basic Performace and Security
            --how many users can access the website without crashing server
         */

        given().
                headers( "Accept","application/json" ).
                header( "Content-Type","application/json" ).

                when().log().all().
                get("/videogames").
                then().log().all().
                assertThat().
                statusCode( 200 );
        // think of headers or simply put think of given() as the "Given reqs to access the info"




    }
    @Test
    public void getSpecificResource(){

        baseURI = "http://localhost:8080/app";
        //to pass parameters we need to declare inside of given and catch it with get using a {variable}
        given().
                header( "Accept","application/json" ).
                pathParam( "videoGameId","2" ). //path parameters are what we need to pass to access, We are passing 2
                when().log().all().
                get("/videogames/{videoGameId}").//this will catch the 2 to display info
                then().log().all().
                assertThat().
                header( "Content-Type","application" ).
                statusCode( 200 );
        //to get a specific resource it is placed inside of a JSON array of objects
        //JSOn body:
        //{
        //    "id": 2,
        //    "name": "Gran Turismo 3",
        //    "releaseDate": "2001-03-10",
        //    "reviewScore": 91,
        //    "category": "Driving",
        //    "rating": "Universal"
        //}
    }



}
