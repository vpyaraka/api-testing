package com.epam;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsersAssignmentReSTModule3 {

    RequestSpecification specification = new RequestSpecBuilder().
            setBaseUri("https://jsonplaceholder.typicode.com/users").
            setContentType("application/json").build();

    @Test
    public void VerifyStatusCode() {
        given().
                spec(specification).log().all().
        when().
                get().

        then().statusCode(200).log().all();
    }

    @Test
    public void VerifyUserName() {

        given().
                spec(specification).log().all().
                
        when().
                get().

        then().
                body("name[1]",equalTo("Ervin Howell")).log().all();

    }
}
