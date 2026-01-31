package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestData {

    public static Integer validID = (int) (System.currentTimeMillis()/1000);
    public static String validUsername = "NIk" + System.currentTimeMillis();
    public static String validFirstname = "Nik";
    public static String validLastname = "HDK";
    public static String validEmail = "petname" + System.currentTimeMillis() + "@gmail.com";
    public static String validPassword = "Pet@123";
    public static String validPhone = "1234567890";
    public static Integer validUserstatus = 1;

    public static Map<String, Object> createUserPayload (){

        Map<String, Object> payload = new HashMap<>();
        payload.put("id", validID);
        payload.put("username", validUsername);
        payload.put("firstname", validFirstname);
        payload.put("lastname", validLastname);
        payload.put("email", validEmail);
        payload.put("password", validPassword);
        payload.put("phone", validPhone);
        payload.put("userstatus", validUserstatus);

        return payload;


    }




}
