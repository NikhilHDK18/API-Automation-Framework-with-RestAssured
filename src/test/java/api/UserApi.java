package api;

import context.ResponseContext;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.patch;

public class UserApi {

    public static Response createUser(Object payload){
        Response response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/user");
        ResponseContext.setLastResponse(response);
        return response;
    }
    public static Response login(String username, String password){

        Response response = given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("/user/login");
        ResponseContext.setLastResponse(response);
        return response;

    }
    public static Response createUserUsingGet() {
        Response response = given()
                .when()
                .get("/user")
                .then()
                .extract().response();
        ResponseContext.setLastResponse(response);
        return response;
    }

    public static Response createUserWithoutContentType(Object payload) {
        Response response = given()
                .body(payload)
                .when()
                .post("/user")
                .then()
                .extract().response();
        ResponseContext.setLastResponse(response);
        return response;
    }



}
