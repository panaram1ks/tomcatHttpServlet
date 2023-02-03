package com.parom.http.socker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws UnknownHostException {


//        InetAddress byName = Inet4Address.getByName("google.com");
        InetAddress localhost = Inet4Address.getByName("localhost");
        try (Socket socket = new Socket(localhost, 7777);
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        ) {

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                outputStream.writeUTF(s);
                System.out.println("Server say: " + inputStream.readUTF());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
