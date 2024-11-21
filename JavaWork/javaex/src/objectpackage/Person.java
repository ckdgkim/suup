package objectpackage;

public class Person {
  private int age;
  private String name;
  private String nat;
  private String address;

  public String getNat() {
    return nat;
  }


  public String getAddress() {
    return address;
  }


  public int getAge() {
    return age;
  }
  public String getName(){
    return name;
  }
  public Person setAge(int age){
    if(age < 0 || age > 130) { // 129살이 가장 많은 나이라고 가정
      System.out.println("나이는 0에서 129 살까지만 입력가능합니다.");
    } else {
      this.age = age;
    }
    return this;
  }
  public Person setName(String name){
    if(name == null || name.equals("") || name.equals(" ")) {
      name = "홍길동";
    } else {
      this.name = name;
    }
    return this;
  }

  public Person setNat(String nat) {
    if(nat == null || nat.equals("") || nat.equals(" ")) {
      this.nat = "대한민국";
    } else {
      this.nat = nat;
    }
    return this;
  }

  public Person setAddress(String address) {
    if(address == null || address.equals("") || address.equals(" ")) {
      this.address = "서울";
    } else {
      this.address = address;
    }
    return this;
  }

  public void sayHello() {
    System.out.printf("국적은 %s 이고, 주소는 %s 이고, 이름은 %s 이고, 나이는 %d 입니다.\n",
        nat, address, name, age);
  }
}
