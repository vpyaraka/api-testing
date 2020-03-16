package com.epam;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class DayThreeBasicTest {

//    http://api.zippopotam.us/us/90210
//    http://api.zippopotam.us/us/85001

    @Test
    public void verifyStatusCode() {
        given().
                baseUri("http://api.zippopotam.us").
        when().
                get("/us/90210").
        then().
                statusCode(200);
    }

    @Test
    public void verifyCountry(){
        given().
                baseUri("http://api.zippopotam.us").
        when().
                get("/us/90210").
        then().
                body("country", equalTo("United States"));
    }

    @Test
    public void verifyCountryAbbreviation(){
        given().
                baseUri("http://api.zippopotam.us").
        when().
                get("/us/90210").
        then().
                body("'country abbreviation'", equalTo("US")).
                body("'post code'", equalTo("90210"));
    }

     @Test
    public void verifyPlaces(){
        given().
                baseUri("http://api.zippopotam.us").log().all().
        when().
                get("/us/90210").
        then().
                body("places[0].state", equalTo("California")).
                body("places[0].longitude", equalTo("-118.4065")).
                body("places[0].latitude", equalTo("34.0901")).
                body("places[0].'place name'", equalTo("Beverly Hills")).
                body("places[0].'state abbreviation'", equalTo("CA")).
                log().all();
    }




}
