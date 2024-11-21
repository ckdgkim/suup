package datastructure;

import java.util.LinkedList;

public class SLinkedListDemo {
  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    System.out.println(ll.size());
    ll.addFirst(10);
    Integer i = ll.removeLast();
    System.out.println(i + "이 삭제되었습니다.");

    System.out.println(ll.size());
    System.out.println(ll);

    SLinkedList<Integer> sll = new SLinkedList<>();
    System.out.println(sll.size());
    sll.addFirst(10);
    sll.addFirst(20);
    sll.addFirst(30);
    sll.addLast(40);
    System.out.println(sll.size());
    System.out.println(sll.getValue(3));
    System.out.println(sll.getNode(3));

    System.out.println(sll.removeFirst() + "이 삭제되었습니다.");
    System.out.println("삭제 후 " + sll.size() + "개 남음");
    System.out.println(sll.removeFirst() + "이 삭제되었습니다.");
    System.out.println("삭제 후 " + sll.size() + "개 남음");
    System.out.println(sll.removeFirst() + "이 삭제되었습니다.");
    System.out.println("삭제 후 " + sll.size() + "개 남음");
  }
}
