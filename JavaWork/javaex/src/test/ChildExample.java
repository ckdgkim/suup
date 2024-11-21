package test;

public class ChildExample {
  public static void main(String[] args) {
    System.out.println("==부모 객체==");
    Parent parent = new Child();
//    부모 = new 자식(업캐스팅)
    parent.field1 = "부모 field1";
//  parent.field2 = "부모 field2";
    System.out.println(parent.field1);
//  System.out.println(parent.field2);
    parent.method1();
    parent.method2();
//  오버라이드 되어 자식의 메서드2가 실행된다.
//  parent.method3();
    System.out.println("==자식 객체==");
    Child child = (Child) parent;
//    자식 = 부모(다운캐스팅)
//    부모 = new 자식(업캐스팅)이 되어있어야 (다운캐스팅이 가능하다.)
    child.field1 = "부모 field1";
    child.field2 = "자식 field2";
    System.out.println(child.field1);
    System.out.println(child.field2);
    child.method1();
    child.method2();
    child.method3();
  }
}
