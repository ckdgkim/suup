package exercise_ch06;

public class JVMMemoryDemo {
  public static void main(String[] args){
    AClass aclass = new AClass(3);
    System.out.println("before a : " + AClass.a);
    System.out.println("before b : " + aclass.b);

    incrementPri(aclass.b);
    incrementRef(aclass);

    System.out.println("after a : " + AClass.a);
    System.out.println("after b : " + aclass.b);
  }

  private static void incrementPri(int b) {
    System.out.println("increment b : " + (++b));
  }

  private static void incrementRef(AClass aclass) {
    System.out.println("increment a : " + (++aclass.a));
  }
}

class AClass {
  static int a;
  int b;
  public AClass(int b) {
    this.b = b;
  }

  int add10(int i) {
    return i + 10;
  }
}
