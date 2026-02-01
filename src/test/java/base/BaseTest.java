package base;

import context.AuthContext;
import config.ApiConfig;
import config.ApiConfig.ApiType;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import reporting.ExtentTestListener;

import java.util.ResourceBundle;

@Listeners(ExtentTestListener.class)
public class BaseTest {

    protected static ResourceBundle config;

    @BeforeClass
    public void setup() {
        config = ResourceBundle.getBundle("config");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    // 🔑 Centralized API selectors (USE THESE)
    protected void usePetStoreApi() {
        ApiConfig.setApi(ApiType.PETSTORE);
    }

    protected void useDummyJsonApi() {
        ApiConfig.setApi(ApiType.DUMMYJSON);
    }

    @AfterSuite
    public void tearDown() {
        AuthContext.clear();
    }





}
