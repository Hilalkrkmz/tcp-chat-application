package chatserver;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader input;
    public PrintWriter output;
    public String username;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {
            input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            output = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }

    @Override
public void run() {

    try {

        username = input.readLine(); // clienttan username al
        System.out.println(username + " bağlandı.");
        Server.log(username + " bağlandı");
        Server.broadcastUserList();

        String message;

        while ((message = input.readLine()) != null) {
        //EXİT
        if (message.equals("EXIT")) {
        System.out.println(username + " çıkış yaptı.");
        Server.clients.remove(this);
        Server.broadcastUserList();
        socket.close();
        break;
    }
      
    //ÖZEL MSJ
    if (message.startsWith("@")) {

    int spaceIndex = message.indexOf(" ");

    // boşluk yoksa hata ver
    if (spaceIndex == -1) {
        output.println("Kullanım: @kullaniciAdi mesaj");
        continue;
    }

    String targetUser = message.substring(1, spaceIndex);
    String privateMsg = message.substring(spaceIndex + 1);

    boolean found = false;

    for (ClientHandler client : Server.clients) {
        if (client.username.equals(targetUser)) {
            client.output.println("(Özel) " + username + ": " + privateMsg);
            found = true;
            break;
        }
    }

    if (!found) {
        output.println("Kullanıcı bulunamadı.");
    }

} else {

    String fullMessage = username + ": " + message;
    Server.log(fullMessage);

    for (ClientHandler client : Server.clients) {
        client.output.println(fullMessage);
    }
}
    
       //FİLE 
    if (message.startsWith("FILE:")) {

   if (message.startsWith("FILE:")) {

    String[] parts = message.split(":");
    String fileName = parts[1];
    long fileSize = Long.parseLong(parts[2]);

    Server.log(username + " dosya gönderdi: " + fileName);

    InputStream is = socket.getInputStream();
    byte[] buffer = new byte[4096];

    // diğer clientlara bilgi gönder
    for (ClientHandler client : Server.clients) {
        if (client != this) {
            client.output.println("FILE:" + username + ":" + fileName + ":" + fileSize);
        }
    }

    long remaining = fileSize;

    while (remaining > 0) {
        int read = is.read(buffer, 0, (int)Math.min(buffer.length, remaining));

        if (read == -1) break;

        for (ClientHandler client : Server.clients) {
            if (client != this) {
                client.socket.getOutputStream().write(buffer, 0, read);
            }
        }

        remaining -= read;
    }

    continue;
}
}
        
        
        }

    } catch (IOException e) {
        System.out.println(username + " ayrıldı.");
        Server.clients.remove(this);
        Server.broadcastUserList();
    }

    try {
        socket.close();
    } catch (IOException e) {
        System.out.println("Socket kapatılamadı.");
    }
}
    
}