package context;

import io.restassured.response.Response;

public class ResponseContext {

    private static final ThreadLocal<Response> lastResponse = new ThreadLocal<>();

    private ResponseContext() {
        // prevent object creation
    }

    public static void setLastResponse(Response response) {
        lastResponse.set(response);
    }

    public static Response getLastResponse() {
        return lastResponse.get();
    }

    public static void clear() {
        lastResponse.remove();
    }
}
