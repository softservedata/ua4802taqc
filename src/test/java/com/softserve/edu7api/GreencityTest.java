package com.softserve.edu7api;

import okhttp3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GreencityTest {

    @Test
    public void checkSignin() throws IOException {
        //
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody;
        Request request;
        Response response;
        String resultJson;
        //
        // Login
        String jsonBody =  new StringBuilder()
                .append("{")
                .append("\"email\":\"veieqvynpcmtwamqgv@xfavaj.com\",")
                .append("\"password\":\"Qwerty_1\",")
                .append("\"projectName\":\"GREENCITY\"")
                .append("}").toString();
        //
        requestBody = RequestBody.create(jsonBody,
                MediaType.parse("application/json; charset=utf-8"));
        //
        request = new Request.Builder()
                .url("https://greencity-user.greencity.cx.ua/ownSecurity/signIn")
                //.addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();
        //
        response = client.newCall(request).execute();
        //
        resultJson = response.body().string();
        System.out.println("resultJson = " + resultJson);
        //
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals(200, response.code());
    }
}
