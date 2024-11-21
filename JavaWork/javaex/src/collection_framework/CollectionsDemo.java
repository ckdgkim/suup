package collection_framework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
  public static void main(String[] args) {
    String[] fruits = {"포도","수박","딸기","사과","배"};
    List<String> list = Arrays.asList(fruits);
//    Collections.sort(list);
//    Collections.reverse(list);
    Collections.sort(list, Collections.reverseOrder());
    for (String s : list) {
      System.out.print(s + " ");
    }
    System.out.println("");
//    for (String s : fruits) {
//      System.out.print(s + " ");
//    }
  }
}
