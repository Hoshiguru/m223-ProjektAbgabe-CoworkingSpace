package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookingResourceTest {

    @Test
    public void testIndexEndpoint() {
        given()
          .when().get("/booking")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }    
}