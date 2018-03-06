import java.io.*;
import java.net.*;
import java.util.*;
class WaughA1Client {
  public static void main(String argv[]) throws Exception{
    Socket client = new Socket("localhost", 22122);
    Scanner keyboard = new Scanner(System.in);
    String inputLine; 
    
    DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());
    
    System.out.println("Enter a URL");
    String inputURL = keyboard.nextLine();
    URL obj = new URL(inputURL);
    outToServer.writeBytes(inputURL + "\n");
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent","Mozilla/5.0");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
    while ((inputLine = in.readLine()) != null){
      outToServer.writeBytes(inputLine + "\n");
      System.out.println(inputLine);
    }
    client.close();
    keyboard.close();
  }
}