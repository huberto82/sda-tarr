package programowanie_zaawansowane.c3_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleServer {
  static List<Socket> register = new ArrayList<>();

  public static void broadcast(String mesage) throws IOException {
    for(Socket s: register){
      PrintWriter out = new PrintWriter(s.getOutputStream(), true);
      out.println(mesage);
    }
  }

  public static void main(String[] args) throws IOException {
    Logger log = Logger.getLogger("My logger");
    try {
      ServerSocket server = new ServerSocket(6666);
      System.out.println(server.getInetAddress());
      while(true){
        log.log(Level.INFO,"Server starting");
        System.out.println("Server waiting for connection.");
        Socket client = server.accept();
        register.add(client);
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
                //clientOutput.println("ECHO: " + message);
                System.out.println("CLIENT SEND " + message);
                if (message.trim().equals("END")){
                  clientOutput.println("BYE");
                  client.close();
                  register.remove(client);
                  return;
                }
                broadcast(message);
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
