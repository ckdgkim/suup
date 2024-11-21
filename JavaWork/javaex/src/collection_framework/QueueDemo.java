package collection_framework;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
  public static void main(String[] args) {
    Queue<String> q = new LinkedList<>();
    System.out.println(q.size());
    System.out.println(q.isEmpty());
    q.offer("바나나");
    System.out.println(q.peek());
    q.offer("사과");
    System.out.println(q.peek());
    q.offer("수박");
    System.out.println(q.peek());

    while(!q.isEmpty()) {
      System.out.println("맨 처음에 있는 element " + q.peek());
      System.out.println("제거된 element " + q.poll());
    }
  }
}
