package com.reqres;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserUpdateValidation {

    /*
	Validation 4:
1.	Update a user
2.	Validate that the response code is `200`
3.	Validate that the response body matches the request body where applicable. Make a recursive comparison if possible
     */

    @Test
    public void userUpdateValidation() {
        String endpoint = "https://reqres.in/api/users/2";

        User user = new User(
                "morpheus",
                "zion resident"
        );
        var response =
                given()
                        .body(user)
                        .when()
                        .patch(endpoint)
                        .then();
        // Log the response body
        response.log().body();
	    
        // Validate that the response code is `200`
        response.assertThat().statusCode(200);
	    
        // Validate that the response body matches the request body where applicable. Make a recursive comparison if possible
	response.assertThat().body("updatedAt", containsString("2024-01-17"));
    }
}
