package interface_package;

public class CoinDemo2 implements Coin, MyInterface{
  public static void main(String[] args) {
    System.out.println("Dime 은 " + DIME + " 입니다.");
    System.out.println("Quarter 는 " + QUARTER + " 입니다.");
  }

  @Override
  public void sayHello() {

  }
}
