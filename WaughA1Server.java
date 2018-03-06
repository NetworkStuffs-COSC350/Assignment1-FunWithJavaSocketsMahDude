import java.io.*;
import java.net.*;

public class WaughA1Server {
  public static void main(String[] args)throws Exception{
    ServerSocket server = new ServerSocket(22122);
    
    while(true){
      String input;
      int lineCount = 0;
      int charCount = 0;
      Socket connectionSocket = server.accept();
      long startTime = System.currentTimeMillis();
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      String webServerName = "Server Name: " + inFromClient.readLine();
      System.out.println(webServerName);
      while((input = inFromClient.readLine()) != null){
        System.out.println(input);
        charCount += input.length();
        lineCount++;
      }
      System.out.println("Delay = " + (System.currentTimeMillis() - startTime) + " Milliseconds");
      System.out.println("Line Count: " + lineCount);
      System.out.println("Character Count: " + charCount);
    }
  }
}