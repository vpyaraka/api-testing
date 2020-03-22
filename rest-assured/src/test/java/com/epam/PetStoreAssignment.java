package com.epam;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreAssignment {

    RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setContentType("application/json").build();

    @Test
    public void VerifyStatusCode() {
        given().
                spec(specification).log().all().
                when().
                get("/pet/2345").

                then().
                statusCode(200).log().all();
    }

    @Test
    public void VerifyPetName() {
        given().
                spec(specification).log().all().
        when().
                get("/pet/2345").

        then().
                assertThat().body("category.name", equalTo("dog")).
                body("name", equalTo("snoopie"));

    }

    @Test
    public void VerifyPetStatus() {
        given().
                spec(specification).log().all().
                when().
                get("/pet/2345").

                then().
                //assertThat().body("category.name", equalTo("dog")).
                body("name", equalTo("snoopie")).
                body("status", equalTo("pending"));

    }

}
