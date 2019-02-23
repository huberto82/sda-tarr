package programowanie_zaawansowane.exercise2.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyChat {
  public static PrintWriter output;

  public static  Scanner input;

  public static Scanner keyboard = new Scanner(System.in);

  public static void runAsServer() throws IOException {
    ServerSocket server = new ServerSocket(5000);
    Socket client = server.accept();
    output = new PrintWriter(client.getOutputStream(), true);
    input = new Scanner(client.getInputStream());
    //
    new Thread(()->{
      while(input.hasNext()){
        System.out.println("Partner: " + input.next());
      }
    }).start();

    String query;
    while(!(query = keyboard.next()).equals("Q")){
      output.println(query);
    }
    //
    server.close();
  }

  public static void runAsClient() throws IOException {
    System.out.println("Podaj adres serwera:");
    String serverIP = keyboard.next();
    Socket server = new Socket(serverIP, 5000);
    output = new PrintWriter(server.getOutputStream(), true);
    input = new Scanner(server.getInputStream());
    //
    new Thread(()->{
      while(input.hasNext()){
        System.out.println("Partner: " + input.next());
      }
    }).start();

    String query;
    while(!(query = keyboard.next()).equals("Q")){
      output.println(query);
    }
    //
    server.close();
  }
  public static void main(String[] args) throws IOException {

    System.out.println("Podaj tryb: S - serwer, C - klient");
    switch (keyboard.next()){
      case "S":
        runAsServer();
        break;
      case"C":
        runAsClient();
        break;
    }
  }
}
