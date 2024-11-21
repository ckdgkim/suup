package collection_framework;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceDemo {
  public static void main(String[] args) {
    ArrayList<Integer> alist = new ArrayList<>();
    LinkedList<Integer> llist = new LinkedList<>();
    long before = System.nanoTime();
    for (int i = 0; i < 100000; i++) {
      alist.add(0,i);
    }
    long after = System.nanoTime();
    System.out.println("arraylist의 맨앞에 추가 : " + (after - before));

    before = System.nanoTime();
    for (int i = 0; i < 100000; i++) {
      llist.addLast(i);
    }
    after = System.nanoTime();
    System.out.println("linkedlist의 맨앞에 추가 : " + (after - before));
  }
}
