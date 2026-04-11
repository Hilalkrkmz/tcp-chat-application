package chatserver;

import java.net.*;
import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Server {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Sunucu başlatıldı. Bağlantı bekleniyor...");

            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("Yeni kullanıcı bağlandı: " + clientSocket);

                ClientHandler handler = new ClientHandler(clientSocket);
                clients.add(handler);

                handler.start();
            }

        } catch (IOException e) {
            System.out.println("Server hatası: " + e.getMessage());
        }
    }
    
    public static void broadcastUserList() {

    StringBuilder users = new StringBuilder("USERLIST:");

    for (ClientHandler client : clients) {
        users.append(client.username).append(",");
    }

    for (ClientHandler client : clients) {
        client.output.println(users.toString());
    }
}
    
    
    public static void log(String message) {
    try {
        FileWriter fw = new FileWriter("log.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        String time = java.time.LocalTime.now().toString();

        pw.println("[" + time + "] " + message);

        pw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}