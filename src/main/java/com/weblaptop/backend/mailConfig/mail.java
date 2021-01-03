package com.weblaptop.backend.mailConfig;

import java.io.File;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class mail {
    // ...
    public static JsonNode sendSimpleMessage( String userEmail,String token) throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "sandbox6d56f42f02464dd68049806f51113557.mailgun.org" + "/messages")
			.basicAuth("api", "ba3e1a682c9eb0aecdba0ab81d51c1d5-c50a0e68-ac42767c")
                .queryString("from", "postmaster@sandbox6d56f42f02464dd68049806f51113557.mailgun.org")
                .queryString("to", userEmail)
                .queryString("subject", "hello")
                .queryString("text", "testing")
                .asJson();
        return request.getBody();
    }
}