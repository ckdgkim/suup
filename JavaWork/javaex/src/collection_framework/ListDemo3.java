package collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo3 {
  public static void main(String[] args) {
    List<String> sList = Arrays.asList("사자", "호랑이", "곰");
    sList.set(2,"판다");
    System.out.println(sList);
 //   sList.add("기린");

    List<String> slist2 = new ArrayList<>(sList);
    slist2.add("기린");
    System.out.println(slist2);
  }
}
