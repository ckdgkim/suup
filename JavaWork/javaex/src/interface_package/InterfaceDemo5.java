package interface_package;

public class InterfaceDemo5 {
  public static void main(String[] args) {
    Animal dog = new Dog();
    Animal cuckoo = new Cuckoo();

    makeSound(dog);
    makeSound(cuckoo);
  }

  public static void makeSound(Animal animal) {
    animal.sound();
  }
}
