package tests;

import base.BaseTest;
import context.AuthContext;
import endpoints.JwtAuthEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JwtTestData;

import java.util.Map;

public class JwtRefreshTokenFlowTest extends BaseTest {

    @BeforeMethod
    public void init() {
        useDummyJsonApi();
    }

    @Test(priority = 1)
    public void loginAndCaptureToken() {

        Response response = JwtAuthEndpoints.login(
                JwtTestData.validLoginRequest()
        );

        Assert.assertEquals(response.getStatusCode(), 200);

        AuthContext.setAccessToken(
                response.jsonPath().getString("accessToken")
        );
        AuthContext.setRefreshToken(
                response.jsonPath().getString("refreshToken")
        );
        AuthContext.setCookies(response.getCookies());
    }

    @Test(priority = 2)
    public void accessApiWithValidAccessToken() {

        Response response =
                JwtAuthEndpoints.getUserProfile(
                        AuthContext.getAccessToken(),
                        AuthContext.getCookies()
                );

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void refreshAccessToken() {

        Response response =
                JwtAuthEndpoints.refreshToken(
                        AuthContext.getRefreshToken(),
                        AuthContext.getCookies()
                );

        Assert.assertEquals(response.getStatusCode(), 200);

        AuthContext.setAccessToken(
                response.jsonPath().getString("accessToken")
        );
        AuthContext.setRefreshToken(
                response.jsonPath().getString("refreshToken")
        );
        AuthContext.setCookies(response.getCookies());

        Assert.assertNotNull(AuthContext.getAccessToken());
    }

    @Test(priority = 4)
    public void accessApiWithNewAccessToken() {

        Response response =
                JwtAuthEndpoints.getUserProfile(
                        AuthContext.getAccessToken(),
                        AuthContext.getCookies()
                );

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
