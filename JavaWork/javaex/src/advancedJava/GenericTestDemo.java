package advancedJava;

import java.util.ArrayList;
import java.util.Objects;

public class GenericTestDemo {
  public static void main(String[] args) {
    ArrayList<Integer> intArray = new ArrayList<>();
    intArray.add(10);
    intArray.add(20);
    intArray.add(30);
    //intArray.add("A");
    System.out.println(intArray.get(2)+10);
    System.out.println(intArray);

    ArrayList<String> strArray = new ArrayList<>();
    //strArray.add(1);
    strArray.add("A");
    strArray.add("B");
    strArray.add("C");
    System.out.println(strArray);

    ArrayList<Object> objArray = new ArrayList<>();
    objArray.add(new Any());
    objArray.add(new All());
    objArray.add(1);
    objArray.add("Str");

    System.out.println(objArray);
    Object o = objArray.get(2);
    if(o instanceof Integer){
      Integer i = (Integer) o;
      System.out.println(i + 10);
    }
    //System.out.println(o + 10); ;
  }
}

class Any {
  int any;
}

class All {
  int all;
}
