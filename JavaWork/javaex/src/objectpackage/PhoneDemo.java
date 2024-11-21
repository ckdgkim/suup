package objectpackage;

public class PhoneDemo {
  public static void main(String[] args) {
    Phone p1 = new Phone();
    p1.setModel("갤럭시 Z 폴드 6");
    p1.setPrice(2_586_000);
    p1.print();

    Phone p2 = new Phone();
    p2.setModel("iPhone 15 Pro");
    p2.setPrice(2_320_000);
    p2.print();
  }
}
