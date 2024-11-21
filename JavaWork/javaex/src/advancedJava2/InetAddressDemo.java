package advancedJava2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressDemo {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress addr1 = null, addr2 = null;
    Scanner in = new Scanner(System.in);

    System.out.println("호스트 이름을 입력하세요");
    String url = in.nextLine();

    addr1 = InetAddress.getByName(url);
    addr2 = InetAddress.getLocalHost();

    System.out.println(addr1.getHostAddress());
    System.out.println(addr2.getHostAddress());

  }
}
