package collection_framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>();
    l = new LinkedList<>();
    boolean add = l.add(10);
    l.add(0,30);
    System.out.println(l);

    System.out.println(l.get(1));
    System.out.println(l.indexOf(10));
    Integer remove = l.remove(0);
    System.out.println(remove + "이 삭제되었습니다.");
    l.add(40);
    System.out.println(l);
    Integer set = l.set(1, 20);
    System.out.println(set +" 이 다른 값으로 변경되었습니다.");
    System.out.println(l);
  }
}
