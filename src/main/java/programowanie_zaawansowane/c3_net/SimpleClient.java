package programowanie_zaawansowane.c3_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      String query = "";
        Socket server = new Socket("localhost", 6666);
        PrintWriter output = new PrintWriter(server.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream()));
      while(!(query = scanner.nextLine()).equals("Q")){
        System.out.println("ECHO " + query);
        output.write("PoST" + System.lineSeparator() + query);
        while (input.ready()) {
          System.out.println(input.readLine());
        }
      }
      server.close();
      input.close();
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
