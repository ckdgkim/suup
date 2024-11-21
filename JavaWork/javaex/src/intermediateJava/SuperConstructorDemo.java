package intermediateJava;

public class SuperConstructorDemo {
  public static void main(String[] args) {
    ColoredBox cb = new ColoredBox(10);
    System.out.println(cb.size);
  }
}

class Box {
  int size;
  //public Box() {}
  public Box(int size){
    this.size = size;
  }
}

class ColoredBox extends Box {
  public ColoredBox(int size) {
    super(size);
  }
}