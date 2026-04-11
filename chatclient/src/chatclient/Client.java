package chatclient;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 1234);

            System.out.println("Servera bağlandı.");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            // kullanıcı adı gönder
            System.out.print("Kullanıcı adı: ");
            String username = scanner.nextLine();
            output.println(username);

            // serverdan mesaj dinleyen thread
            new Thread(() -> {
                try {
                    String message;
                    while ((message = input.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (Exception e) {
                    System.out.println("Bağlantı kesildi.");
                }
            }).start();

            // mesaj gönder
            while (true) {
                String message = scanner.nextLine();
                output.println(message);
            }

        } catch (Exception e) {
            System.out.println("Servera bağlanamadı.");
        }
    }
}