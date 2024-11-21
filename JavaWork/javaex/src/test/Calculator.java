package test;

public class Calculator {
  public double areaCircle(double r){
    System.out.println("Calculator 객체의 areaCircle() 실행");
    return 3.14 * r * r;
  }
}

class Computer extends Calculator{
  @Override
  public double areaCircle(double r) {
    System.out.println("Computer 객체의 areaCircle() 실행");
    return 100 * r * r;

  }
}
