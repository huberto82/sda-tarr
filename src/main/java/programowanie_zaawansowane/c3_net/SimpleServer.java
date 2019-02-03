package programowanie_zaawansowane.c3_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleServer {
  public static void main(String[] args) {
    List<String> safeList = Collections.synchronizedList(new ArrayList<>());
    try {
      ServerSocket server = new ServerSocket(6666);
      while(true){
        Socket client = server.accept();
        System.out.println("Request accepted. "+client);
        new Thread(()->{
          try {
            System.out.println("Thread started");
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter clientOutput = new PrintWriter(client.getOutputStream(), true);
            String message ="";
            while(true) {
              message = clientInput.readLine();
              safeList.add(message);
              if (message != null){
                switch(message){
                  case "END":
                    clientInput.close();
                    client.close();
                    clientOutput.close();
                    System.out.println("Data acquired. Connection closed");
                    return;
                  case "GET":
                    for(String str: safeList){
                      clientOutput.println(str);
                    }
                    clientInput.close();
                    client.close();
                    clientOutput.close();
                    System.out.println("Data send. Connection closed");
                    return;
                  default:
                    System.out.println("DATA "+message);
                    safeList.add(message);
                }
              }
            }

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
