package com.softserve.edu8api;

import com.google.gson.Gson;
import com.softserve.edu7api.GreencityLogin;
import okhttp3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabitsTest {

    @Test
    public void checkMyHabits() throws Exception {
        Gson gson = new Gson();
        //
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody;
        Request request;
        Response response;
        //
        GreencityLogin greencityLogin;
        HabitsPage habitsPage;
        //
        String resultJson;
        String token;
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
        request = new Request.Builder()
                .url("https://greencity-user.greencity.cx.ua/ownSecurity/signIn")
                .addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        greencityLogin = gson.fromJson(resultJson, GreencityLogin.class);
        token = greencityLogin.getAccessToken();
        //
        System.out.println("resultJson = " + resultJson);
        System.out.println("AccessToken = " + token);
        //
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals(286, greencityLogin.getUserId());
        Assertions.assertEquals("Qwerty1", greencityLogin.getName());
        //
        // Get My Habits
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://greencity.greencity.cx.ua/habit/my").newBuilder();
        urlBuilder.addQueryParameter("page", "0");
        urlBuilder.addQueryParameter("size", "20");
        String url = urlBuilder.build().toString();
        //
        request = new Request
                .Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("Authorization", "Bearer " + token)
                .get()
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        habitsPage = gson.fromJson(resultJson, HabitsPage.class);
        //
        Assertions.assertTrue(response.isSuccessful());
        System.out.println("resultJson: " + resultJson);
        System.out.println("greencityMyHabits: " + habitsPage);
        //
    }
}
