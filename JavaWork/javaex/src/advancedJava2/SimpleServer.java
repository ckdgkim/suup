package advancedJava2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(5000);
      Socket conn = server.accept();
      InputStream is = conn.getInputStream();
      ObjectInputStream ois = new ObjectInputStream(is);
      String msg = (String) ois.readObject();
      System.out.println("받은 문자열은 " + msg );
    } catch (Exception e) {
    }
  }
}
