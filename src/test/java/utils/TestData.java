package utils;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    public static Map<String, Object> createUserPayload() {

        long timestamp = System.currentTimeMillis();

        Map<String, Object> payload = new HashMap<>();
        payload.put("id", timestamp);
        payload.put("username", "Nik_" + timestamp);
        payload.put("firstName", "Nik");
        payload.put("lastName", "HDK");
        payload.put("email", "petname" + timestamp + "@gmail.com");
        payload.put("password", "Pet@123");
        payload.put("phone", "1234567890");
        payload.put("userStatus", 1);

        return payload;
    }
}
