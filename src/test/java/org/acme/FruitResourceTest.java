package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.acme.models.Fruit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@QuarkusTest
public class FruitResourceTest {

    @Test
    public void testAddFruit() {
        final Fruit ananas = new Fruit("ananas", "It's not an apple from a pine");
        given()
            .contentType(ContentType.JSON)
            .body(ananas)
          .when().post("/fruits")
          .then()
             .statusCode(200);
    }



}
