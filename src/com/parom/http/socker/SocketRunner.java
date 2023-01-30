package com.parom.http.socker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args){

        try (Socket socket = new Socket("google.com", 80);
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())
        ) {
            outputStream.writeUTF("hello google!");

            var response = inputStream.readAllBytes();

            System.out.println(response.length);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
