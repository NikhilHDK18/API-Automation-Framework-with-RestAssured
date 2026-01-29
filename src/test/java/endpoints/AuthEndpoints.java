package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthEndpoints {

    public static Response login(Integer id, String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {

        String payload = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"" + phone + "\",\n" +
                "  \"userStatus\": " + userStatus + "\n" +
                "}";

        return
                given()
                        .header("content-type", "application/json")
                        .body(payload)
                        .when()
                        .post("/v2/user")
                        .then()
                        .log().all()
                        .extract().response();

    }
}
