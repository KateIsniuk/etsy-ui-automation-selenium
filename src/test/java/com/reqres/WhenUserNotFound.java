package com.reqres;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class WhenUserNotFound {
   
    /*
	Validation 2:
1.	Get single user 13
2.	Validate that the user is not found.
3.	Validate that the response code is `404.`
     */


    @Test
    public void userNotFound() {
        String endpoint = "https://reqres.in/api/users/13";
        var response =
                given()
                        .when()
                        .get(endpoint)
                        .then()
                        .assertThat().statusCode(404)
                        .log().body();
    }
}
