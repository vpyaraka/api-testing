package com.epam;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DayThreeSpecTest {

//    http://api.zippopotam.us/us/90210
//    http://api.zippopotam.us/us/85001

    RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri("http://api.zippopotam.us")
            .setContentType("application/json").build();

    @Test
    public void verifyStatusCode() {
        given().
                spec(specification).
        when().
                get("/us/90210").
        then().
                statusCode(200);
    }

    @Test
    public void verifyCountry(){
        given().
                spec(specification).
        when().
                get("/us/90210").
        then().
                body("country", equalTo("United States"));
    }

    @Test
    public void verifyCountryAbbreviation(){
        given().
                spec(specification).
        when().
                get("/us/90210").
        then().
                body("'country abbreviation'", equalTo("US")).
                body("'post code'", equalTo("90210"));
    }

     @Test
    public void verifyPlaces(){
        given().
                spec(specification).log().all().
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
