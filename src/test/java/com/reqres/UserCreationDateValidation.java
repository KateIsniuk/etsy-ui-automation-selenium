package com.reqres;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class UserCreationDateValidation {

    /*
	Validation 3:
1.	Create a new user
2.	Validate that the response code is `201`
3.	Validate that the creation date is today
     */

    @Test
    public void userCreationDateValidation() {
        String endpoint = "https://reqres.in/api/users";
       
	//Create a new user
	    String body = """
                {
                  "name": "morpheus",
                  "job": "leader"
                }
                """;
        // Send the request and capture the response
        var response =
                given().body(body)
                        .when()
                        .post(endpoint)
                        .then();
        // Log the response body
        response.log().body();

        // Validate that the response code is `201`
        response.assertThat().statusCode(201);

        // Validate that the creation date is today's
        response.assertThat().body("createdAt", containsString("2024-01-17"));

    }

}
