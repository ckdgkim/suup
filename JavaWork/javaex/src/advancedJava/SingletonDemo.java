package advancedJava;

public class SingletonDemo {
  public static void main(String[] args) {
//    Singleton singleton = null; // new Singleton();

    Singleton i1 = Singleton.getInstance();
    Singleton i2 = Singleton.getInstance();
    System.out.println(i1.getValue());
    System.out.println(i2.getValue());

    System.out.println(i1 == i2);
    System.out.println(i1);
    System.out.println(i2);
  }
}

class Singleton {
  private static Singleton singleton = new Singleton();
  private Singleton(){
  }

  public int getValue(){
    return 10;
  }

  public static Singleton getInstance(){
    return singleton;
  }
}