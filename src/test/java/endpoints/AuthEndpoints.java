package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthEndpoints {

    public static Response login (String username, String password)
    {
        return given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("/user/login");
    }

    public static Response logout()
    {
        return given()
                .when()
                .get("/user/logout");

    }


}
