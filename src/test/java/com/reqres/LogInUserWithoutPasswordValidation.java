package com.reqres;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LogInUserWithoutPasswordValidation {

    /*
	Validation 7:
1.	Login user without password
2.	Validate that the user could not log in
3.	Validate that the response code is `400`
4.	Validate that the error message is ` Missing password`
     */

    @Test
    public void userCannotLogInWithoutPassword() {
        String endpoint = "https://reqres.in/api/login";
       
	    // Login user without password
	    String body = """
                {
                 "email": "peter@klaven"
                }
                """;
        // Send the request and capture the response
        var response =
                given().body(body)
                        .when()
                        .post(endpoint)
                        .then();
        // Validate that the user could not log in
        response.log().all();

        // Validate that the response code is `400`
        response.assertThat().statusCode(400);

        // Validate that the error message is ` Missing password`
        response.assertThat().body("error", containsString("Missing email or username"));

    }
}
