package advancedJava2;

public class MethodRefDemo {
  public static void main(String[] args) {
    Mathematical m;
    int abs = Math.abs(-10);
//    m = new Mathematical() {
//      @Override
//      public double calculate(double d) {
//        return 0;
//      }
//    };
    //m = (d) -> Math.abs(d);
    m = Math::abs;
    System.out.println(m.calculate(-3.2));
  }
}

interface Mathematical {
  double calculate(double d);
}