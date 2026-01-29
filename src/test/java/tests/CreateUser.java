package tests;

import base.BaseTest;
import endpoints.AuthEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

public class CreateUser extends BaseTest {

    @Test
    public void createNewUser(){

        Response response = AuthEndpoints.login(
                TestData.validID,
                TestData.validUsername,
                TestData.validFirstname,
                TestData.validLastname,
                TestData.validEmail,
                TestData.validPassword,
                TestData.validPhone,
                TestData.validUserstatus

        );

        Assert.assertEquals(response.getStatusCode(), 200);


    }

}
