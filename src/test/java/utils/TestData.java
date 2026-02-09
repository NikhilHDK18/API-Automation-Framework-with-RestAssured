package utils;

import java.util.ResourceBundle;
import java.util.function.Consumer;

import pojo.UserPayload;

public class TestData {

    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");
    private static final String KEY_USERNAME_PREFIX = "user.default.username.prefix";
    private static final String KEY_FIRST_NAME = "user.default.firstName";
    private static final String KEY_LAST_NAME = "user.default.lastName";
    private static final String KEY_EMAIL_PREFIX = "user.default.email.prefix";
    private static final String KEY_EMAIL_DOMAIN = "user.default.email.domain";
    private static final String KEY_PASSWORD = "user.default.password";
    private static final String KEY_PHONE = "user.default.phone";
    private static final String KEY_USER_STATUS = "user.default.userStatus";

    public static long newTimestamp() {
        return System.currentTimeMillis();
    }

    public static UserPayload createUserPayload() {
        return createUserPayloadWithTimestamp(newTimestamp());
    }

    public static UserPayload createUserPayloadWithTimestamp(long timestamp) {
        return baseUserPayloadBuilder(timestamp).build();
    }

    public static UserPayload createUserPayload(Consumer<UserPayload.UserPayloadBuilder> overrides) {
        long timestamp = newTimestamp();
        UserPayload.UserPayloadBuilder builder = baseUserPayloadBuilder(timestamp);
        if (overrides != null) {
            overrides.accept(builder);
        }
        return builder.build();
    }

    private static UserPayload.UserPayloadBuilder baseUserPayloadBuilder(long timestamp) {
        return UserPayload.builder()
                .id(timestamp)
                .username(configString(KEY_USERNAME_PREFIX) + timestamp)
                .firstName(configString(KEY_FIRST_NAME))
                .lastName(configString(KEY_LAST_NAME))
                .email(configString(KEY_EMAIL_PREFIX) + timestamp + configString(KEY_EMAIL_DOMAIN))
                .password(configString(KEY_PASSWORD))
                .phone(configString(KEY_PHONE))
                .userStatus(configInt(KEY_USER_STATUS));
    }

    private static String configString(String key) {
        return CONFIG.getString(key);
    }

    private static int configInt(String key) {
        return Integer.parseInt(configString(key));
    }
}
