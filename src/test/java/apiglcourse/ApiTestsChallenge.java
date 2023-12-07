package apiglcourse;

import models.Product;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTestsChallenge {

    /*
- Create a product called "Sweatband" in Category 3 for 10$
- Update the Sweatband price to 5$
- Retrieve information (ID, name, description, price, category_id, category_name) about Sweatband
- Delete the Sweatband product
   */

    @Test
    public void createSerializedProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product products = new Product(
                "Sweatband",
                "New product",
                10,
                3
        );
        var response = given().body(products).when().post(endpoint).then();
        response.log().body();
    }
    
    @Test
    public void getProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
                given()
                        .queryParam("id", 23)
                        .when()
                        .get(endpoint)
                        .then()
                        .log()
                        .body()
                                .assertThat()
                        .statusCode(200).body("id", equalTo("23"))
                        .body("name", equalTo("Blue water buttle"))
                        .body("description", equalTo("New product"))
                        .body("price", equalTo("12.00"))
                        .body("category_id", equalTo(3))
                        .body("category_name", equalTo("Active Wear - Unisex"));

    }
    @Test
    public void getProducts(){
        String endpoint = "http://localhost:8888/api_testing/product/read.php";
                given()
                        .when()
                        .get(endpoint)
                        .then()
                        .log()
                        .headers()
                        .assertThat()
                        .statusCode(200)
                        .header("Content-Type", Matchers.equalTo("application/json; charset=UTF-8"))
                        .body("records.size()", greaterThan(0))
                        .body("records.id", everyItem(notNullValue()))
                        .body("records.name", everyItem(notNullValue()))
                        .body("records.description", everyItem(notNullValue()))
                        .body("records.price", everyItem(notNullValue()))
                        .body("records.category_id", everyItem(notNullValue()))
                        .body("records.category_name", everyItem(notNullValue()))
                        .body("records.id[0]", Matchers.equalTo(25));
    }

    @Test
     public void updateProduct() {
         String endpoint = "http://localhost:8888/api_testing/product/update.php";
         Product product = new Product(
                 24,
                 "Sweatband",
                 "New product",
                 5,
                 3,
                 "Some name"
         );
         var response = given().body(product).when().put(endpoint).then();
         response.log().body();
     }
    
    @Test
    public void deleteProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """
                 {
                 "id": 24
                 }
                 """;
        var response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }
    
    @Test
    public void getSpecificProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";

        given()
                .queryParam("id", 18)
                .when()
                .get(endpoint)
                .then()
                .log()
                .body()
                .assertThat()
                .header("Content-Type", Matchers.equalTo("application/json"))
                .statusCode(200).body("id", equalTo("18"))
                .body("name", equalTo("Multi-Vitamin (90 capsules)"))
                .body("description", equalTo("A daily dose of our Multi-Vitamins fulfills a day’s nutritional needs for over 12 vitamins and minerals."))
                .body("price", equalTo("10.00"))
                .body("category_id", equalTo(4))
                .body("category_name", equalTo("Supplements"));
    }
}
