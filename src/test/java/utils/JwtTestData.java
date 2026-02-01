package utils;

import pojo.LoginRequest;

import java.util.HashMap;
import java.util.Map;

public class JwtTestData {

    public static LoginRequest validLoginRequest() {
        return LoginRequest.builder()
                .username("emilys")
                .password("emilyspass")
                .expiresInMins(30)
                .build();
    }


    public static LoginRequest invalidUsernameLoginRequest() {
        return LoginRequest.builder()
                .username("invalid_user")
                .password("wrong_password")
                .build();
    }

    public static LoginRequest emptyPasswordLoginRequest() {
        return LoginRequest.builder()
                .username("emilys")
                .password("")
                .build();
    }

    public static LoginRequest nullUsernameLoginRequest() {
        return LoginRequest.builder()
                .username(null)
                .password("emilyspass")
                .build();
    }


//    public static LoginRequest loginPayload() {
//    }
}
