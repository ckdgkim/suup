package interface_package;

public class AnonymousDemo2 {
  public static void main(String[] args) {
    Parent p = new Parent() {
      int innerField = 100;
      @Override
      public void callOnce() {
        System.out.println("딱 한 번만 호출됩니다.");
        newMethod();
        System.out.println(innerField);
      }
      public void newMethod(){
        System.out.println("익명객체의 새로운 메서드입니다.");
      }
    };
    p.callOnce();
    //p.newMethod();
    //System.out.println(p.innerField);
  }
}

interface Parent {
  void callOnce();
}
//
//class OnlyOnce implements Parent {
//  @Override
//  public void callOnce() {
//    System.out.println("딱 한 번만 호출됩니다.");
//  }
//}