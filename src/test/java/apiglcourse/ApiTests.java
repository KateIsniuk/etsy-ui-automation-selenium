package apiglcourse;

import models.Products;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {
   
    @Test
    public void getCategories(){
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        var response =
                given().
                        queryParam("id", 2).
                        when().
                        get(endpoint).
                        then();
        response.log().body();
    }

    @Test
    public void createProducts(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        String body = """
        {
        "name": "TEST",
        "description": "TEST",
        "price": 50,
        "category_id": 3
        }
        """;
        var response = given().body(body).when().post(endpoint).then();
        response.log().body();
    }

     @Test
     public void updateProduct() {
         String endpoint = "http://localhost:8888/api_testing/product/update.php";
         String body = """
                 {
                 "id": 22
                 "name": "TEST",
                 "description": "TEST",
                 "price": 25,
                 "category_id": 3
                 }
                 """;
         var response = given().body(body).when().put(endpoint).then();
         response.log().body();
     }
  
    @Test
    public void deleteProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """
                 {
                 "id": 22
                 }
                 """;
        var response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }

    @Test
    public void createSerializedProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Products products = new Products(
                "Blue water bottle",
                "New product",
                12,
                3
        );
        var response = given().body(products).when().post(endpoint).then();
        response.log().body();
    }
}
