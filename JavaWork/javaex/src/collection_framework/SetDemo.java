package collection_framework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
  public static void main(String[] args) {
    Set<String> set = Set.of("바나나","사과","블루베리","무화과","포도");
    HashSet<String> hs = new HashSet<>(set);
    hs.add("수박");
    Iterator<String> iterator = hs.iterator();
    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
    boolean add = hs.add("수박");
    System.out.println(add);
    System.out.println(hs.size());
  }
}
