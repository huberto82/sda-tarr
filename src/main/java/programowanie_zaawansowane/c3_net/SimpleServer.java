package programowanie_zaawansowane.c3_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(6666);
      System.out.println(server.getInetAddress());
      while(true){
        System.out.println("Server waiting for connection.");
        Socket client = server.accept();

        System.out.println("Request accepted. "+client);
        //Wątek obsługujący połączenie z klientem
        new Thread(()->{
          try {
            System.out.println("Thread started for client ");
            Scanner clientInput = new Scanner(new InputStreamReader(client.getInputStream()));
            PrintWriter clientOutput = new PrintWriter(client.getOutputStream(), true);
            clientOutput.println("SERVER: CLIENT CONNECTED" + client.getInetAddress());
            while(clientInput.hasNext()){
                String message = clientInput.nextLine();
                clientOutput.println("ECHO: " + message);
                System.out.println("CLIENT SEND " + message);
                if (message.trim().equals("END")){
                  clientOutput.println("BYE");
                  client.close();
                  return;
                }
            }
            System.out.println("Thread ended");
          } catch (IOException e) {
            e.printStackTrace();
          }
        }).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
