//package advancedJava;
//
//import javax.swing.*;
//
//public class BoxTest {
//  public static void main(String[] args) {
//    Box<Integer> i = new Box<>(100);
//    i.setValue(Integer.valueOf(100));
//    System.out.println(i.getValue() + 100);
//
//    Box<String> s = new Box<>();
//    s.setValue("만능이네");
//    System.out.println(s.getValue() + "!!!");
//  }
//}
//
//class Box< T>{
//  private T Value;
//
//
//  public T getValue() {
//    return Value;
//  }
//
//  public void setValue(T value) {
//    Value = value;
//  }
//}