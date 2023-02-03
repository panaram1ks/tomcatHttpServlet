package com.parom.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();
        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(URI.create("file:/home/evgen/IdeaProjects/httpservletsocket/src/com/parom/http/socker/DatagramRunner.java"))))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.headers().toString());
    }
}
