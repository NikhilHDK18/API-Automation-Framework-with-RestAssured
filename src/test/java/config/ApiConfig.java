package config;

import io.restassured.RestAssured;

import java.util.ResourceBundle;

public class ApiConfig {

    private static final ResourceBundle config =
            ResourceBundle.getBundle("config");

    public enum ApiType {
        PETSTORE,
        DUMMYJSON
    }

    public static void setApi(ApiType apiType) {

        switch (apiType) {
            case PETSTORE:
                RestAssured.baseURI = config.getString("petstore.base.url");
                break;

            case DUMMYJSON:
                RestAssured.baseURI = config.getString("dummyjson.base.url");
                break;

            default:
                throw new RuntimeException("Unsupported API type");
        }
    }
}
