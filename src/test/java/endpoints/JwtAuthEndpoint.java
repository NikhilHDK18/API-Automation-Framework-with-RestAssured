package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;

import java.util.Map;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class JwtAuthEndpoint {

    private static final String LOGIN = "/auth/login";
    private static final String PROFILE = "/auth/me";
    private static final String REFRESH = "/auth/refresh";

    /* -------------------------
       LOGIN
       ------------------------- */

    public static Response login(Map<String, Object> payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(LOGIN);
    }

    // POJO-based login
    public static Response login(LoginRequest payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(LOGIN);
    }

    /* -------------------------
       SECURED API (token + cookies)
       ------------------------- */

    public static Response getUserProfile(
            String accessToken,
            Map<String, String> cookies
    ) {

        RequestSpecification request = given()
                .header("Authorization", "Bearer " + accessToken);

        if (cookies != null && !cookies.isEmpty()) {
            request.cookies(cookies);
        }

        return request
                .when()
                .get(PROFILE)
                .then()
                .extract()
                .response();
    }

    /* -------------------------
       SECURED API (token only)
       ------------------------- */

    public static Response getUserProfileWithTokenOnly(String accessToken) {

        return given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(PROFILE)
                .then()
                .extract()
                .response();
    }

    /* -------------------------
       REFRESH TOKEN
       ------------------------- */

    public static Response refreshToken(
            String refreshToken,
            Map<String, String> cookies
    ) {

        RequestSpecification request = given()
                .contentType(ContentType.JSON);

        if (refreshToken != null) {
            Map<String, String> body = new HashMap<>();
            body.put("refreshToken", refreshToken);
            request.body(body);
        }

        if (cookies != null && !cookies.isEmpty()) {
            request.cookies(cookies);
        }

        return request
                .when()
                .post(REFRESH)
                .then()
                .extract()
                .response();
    }
}
