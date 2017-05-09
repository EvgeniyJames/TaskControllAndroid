package com.zamkovenko.taskcontroll.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * User: Yevgeniy Zamkovenko
 * Date: 09.05.2017
 */

public class SimpleRequest extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {

        String host = "192.168.176.53:8080";

        String url = "http://" + host + "/getmessage";

        HttpAuthentication authHeader = new HttpBasicAuthentication("user", "password");
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAuthorization(authHeader);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

// Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

// Add the String message converter
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(requestHeaders), String.class);


        Log.d("App", response.getBody());
        return null;
    }
}
