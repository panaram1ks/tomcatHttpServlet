package com.parom.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("file:/home/parom/IdeaProjects/httpservletrunner/src/com/parom/http/socker/DatagramRunner.java");
        URLConnection urlConnection = url.openConnection();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static URLConnection checkGoogle() throws IOException {
        URL url = new URL("https://www.google.com");
        //        //get method // doInput = true
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        try (OutputStream outputStream = urlConnection.getOutputStream()) {

        }
        return urlConnection;
    }
}
