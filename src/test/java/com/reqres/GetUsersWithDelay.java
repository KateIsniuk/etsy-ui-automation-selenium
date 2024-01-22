package com.reqres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetUsersWithDelay {
    @DataProvider(name = "delayValues")
    public Object[][] delayValues() {
        return new Object[][]{
                {0},
                {3}
        };
    }

    @Test
    public void getUsersWithDelay() {
        int delay = 0;
        String endpoint = "https://reqres.in/api/users?page=2";
        given()
                .param("delay", delay)
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(1000L)); // Response time less than 1 second
    }
}

