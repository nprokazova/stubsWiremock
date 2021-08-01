package com.example.studsWiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
class StudsWiremockApplicationTests {

    private static WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(5050));

    @BeforeAll
    public static void setUpMockServer() {
        wireMockServer.start();

        WireMock.configureFor("localhost", 5050);

    }

    @Test
    void contextLoads() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/users/2"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withBody("{\n" +
                                "    \"data\": {\n" +
                                "        \"id\": 2,\n" +
                                "        \"email\": \"janete.weaver@reqres.in\",\n" +
                                "        \"first_name\": \"Janete\",\n" +
                                "        \"last_name\": \"Weaver\",\n" +
                                "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                                "    },\n" +
                                "    \"support\": {\n" +
                                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                                "    }\n" +
                                "}")));

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
//				.get("https://reqres.in/api/users/2")
                .get("http://localhost:5050/api/users/2")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        System.out.println(response.getBody().prettyPrint());
        Assertions.assertEquals("Janete", response.jsonPath().getString("data.first_name"));
        Assertions.assertEquals("Weaver", response.jsonPath().getString("data.last_name"));
    }


    //"Получение информации о первом пользователе"
    @Test
    public void getTestsActions1() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/users/1"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withBody("{\n" +
                                "    \"data\": {\n" +
                                "        \"id\": 1,\n" +
                                "        \"email\": \"george.bluth@reqres.in\",\n" +
                                "        \"first_name\": \"George\",\n" +
                                "        \"last_name\": \"Bluth\",\n" +
                                "        \"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"\n" +
                                "    },\n" +
                                "    \"support\": {\n" +
                                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                                "    }\n" +
                                "}")));

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:5050/api/users/1")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        System.out.println(response.getBody().prettyPrint());
        Assertions.assertEquals("George", response.jsonPath().getString("data.first_name"));
        Assertions.assertEquals("Bluth", response.jsonPath().getString("data.last_name"));
    }

    //"Получение информации о третьем пользователе"
    @Test
    public void getTestsActions3() {

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/users/3"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withBody("{\n" +
                                "    \"data\": {\n" +
                                "        \"id\": 3,\n" +
                                "        \"email\": \"emma.wong@reqres.in\",\n" +
                                "        \"first_name\": \"Emma\",\n" +
                                "        \"last_name\": \"Wong\",\n" +
                                "        \"avatar\": \"https://reqres.in/img/faces/3-image.jpg\"\n" +
                                "    },\n" +
                                "    \"support\": {\n" +
                                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                                "    }\n" +
                                "}")));

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:5050/api/users/3")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        System.out.println(response.getBody().prettyPrint());
        Assertions.assertEquals("Emma", response.jsonPath().getString("data.first_name"));
        Assertions.assertEquals("Wong", response.jsonPath().getString("data.last_name"));
        Assertions.assertEquals("emma.wong@reqres.in", response.jsonPath().getString("data.email"));
        Assertions.assertEquals("https://reqres.in/img/faces/3-image.jpg", response.jsonPath().getString("data.avatar"));
    }

    //"Получение информации о пятом пользователе"
    @Test
    public void getTestsAction5() {

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/users/5"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withBody("{\n" +
                                "    \"data\": {\n" +
                                "        \"id\": 5,\n" +
                                "        \"email\": \"charles.morris@reqres.in\",\n" +
                                "        \"first_name\": \"Charles\",\n" +
                                "        \"last_name\": \"Morris\",\n" +
                                "        \"avatar\": \"https://reqres.in/img/faces/5-image.jpg\"\n" +
                                "    },\n" +
                                "    \"support\": {\n" +
                                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                                "    }\n" +
                                "}")));

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:5050/api/users/5")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        System.out.println(response.getBody().prettyPrint());
        Assertions.assertEquals("Charles", response.jsonPath().getString("data.first_name"));
        Assertions.assertEquals("Morris", response.jsonPath().getString("data.last_name"));
        Assertions.assertEquals("charles.morris@reqres.in", response.jsonPath().getString("data.email"));
        Assertions.assertEquals("https://reqres.in/img/faces/5-image.jpg", response.jsonPath().getString("data.avatar"));
    }

    @AfterAll
    public static void tearDownMockServer() {
        wireMockServer.stop();
    }

}
