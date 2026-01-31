package tests;

import base.BaseTest;
import endpoints.UserInfo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

public class CreateUser extends BaseTest {

    @Test
    public void createNewUser(){

        Response response = UserInfo.createUser(
                TestData.createUserPayload()
        );

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("message"));

    }

}
