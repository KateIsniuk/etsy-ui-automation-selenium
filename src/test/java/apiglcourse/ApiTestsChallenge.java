package apiglcourse;

import models.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

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
        var response =
                given().
                        queryParam("id", 24).
                        when().
                        get(endpoint).
                        then();
        response.log().body();
    }

     @Test
     public void updateProduct() {
         String endpoint = "http://localhost:8888/api_testing/product/update.php";
         Product product = new Product(
                 24,
                 "Sweatband",
                 "New product",
                 5,
                 3
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
}
