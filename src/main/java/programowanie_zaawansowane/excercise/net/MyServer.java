package programowanie_zaawansowane.excercise.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(6565);
      Socket client = server.accept();
      System.out.println("Zgłosił się klient!!!");
      //wysyłanie i odbieranie danych od klienta
      //strumień do wysyłania danych do klienta
      PrintWriter output = new PrintWriter(client.getOutputStream(), true);
      //strumień do odbierania danych od klienta
      Scanner input = new Scanner(client.getInputStream());
      output.println("Witaj na serwerze!");

      while(input.hasNext()){
        output.println("ECHO "+ input.next());
      }

      System.out.println("Koniec połączenia");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
