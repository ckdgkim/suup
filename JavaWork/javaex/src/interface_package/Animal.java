package interface_package;

/**
 * 모든 동물은 소리를 낸다. ==> 인터페이스
 * 강아지는 멍멍,뻐꾸기(Cuckcoo)는 뻐꾹 ==> 구현
 */

public interface Animal {
  void sound();
}

class Dog implements Animal {
  @Override
  public void sound() {
    System.out.println("멍멍");
  }
}

class Cuckoo implements Animal {
  @Override
  public void sound() {
    System.out.println("뻐꾹");
  }
}