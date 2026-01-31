package utils;

import java.util.HashMap;
import java.util.Map;

public class JwtTestData {

    public static Map<String, Object> loginPayload() {

        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "emilys");
        payload.put("password", "emilyspass");

        return payload;
    }
}
