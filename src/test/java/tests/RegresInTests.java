package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class RegresInTests {

    /*
        1. make POST- request to https://reqres.in/api/login
            with body { "email": "eve.holt@reqres.in", "password": "cityslicka" }
        2. get response { "token": "QpwL5tke4Pnpja7X4" }
        3. check token is "QpwL5tke4Pnpja7X4"
     */

    @Test
    void loginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\" }"; // todo bad practice

        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(body)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void name() {
        DateTimeFormatter basicIsoDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime localDate = LocalDateTime.parse("22.11.2022", basicIsoDate);

        localDate.getDayOfWeek();

    }
}
