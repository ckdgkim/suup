package basic;

class Animal {
  void sound() {
    System.out.println("Animal makes a sound");
  }
}

class Dog extends Animal {
  void sound() {
    System.out.println("Dog barks");
  }

  void fetch() {
    System.out.println("Dog fetches the ball");
  }
}

public class test {
  public static void main(String[] args) {
    Animal animal = new Dog(); // 업캐스팅: Dog 객체가 Animal 타입으로 변환
    animal.sound(); // "Dog barks" 출력 (오버라이딩된 메서드 호출)

    // 다운캐스팅 시도
    if (animal instanceof Dog) {
      Dog dog = (Dog) animal; // 다운캐스팅: Animal 타입을 Dog 타입으로 변환
      dog.fetch(); // "Dog fetches the ball" 출력 (Dog 클래스의 메서드 호출)
    }
  }
}
