package com.reqres;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetListOfAllUsers {

    /*
    	Validation 1:
1.	Get a list of users
2.	Validate that the response code is `200`
3.	Print all users with odd ID numbers.
     */
    @Test
    public void getListOfAllUsers() {
        String endpoint = "https://reqres.in/api/users?page=2";
        Response response =
                given()
                        .when()
                        .get(endpoint)
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();
        response.jsonPath().getList("data.findAll { it.id % 2 != 0 }").forEach(System.out::println);
    }
}
