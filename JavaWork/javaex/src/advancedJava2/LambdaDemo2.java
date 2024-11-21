package advancedJava2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo2 {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,4,5,2,3);
    Collections.sort(list);
    //1. Collections.reverse(list);
    //2. Collections.sort(list, Collections.reverseOrder());
    //3. lambda
//    Collections.sort(list, new Comparator<Integer>() {
//          @Override
//          public int compare(Integer o1, Integer o2) {
//            return o2 - o1;
//          }
//      });

    Collections.sort(list, (i1,i2) -> i2 - i1);

    System.out.println(list);
  }
}
