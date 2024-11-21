package test;

public class Child extends Parent {
  public String field2;

  @Override
  public void method2(){
    System.out.println("자식 method2");
  }

  public void method3(){
    System.out.println("자식 method3");
  }
}
