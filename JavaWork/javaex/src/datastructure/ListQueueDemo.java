package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class ListQueueDemo {
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(10);
    q.offer(20);
    q.offer(30);
    while(!q.isEmpty()) {
      System.out.println(q.poll() + "이 큐에서 제거됨");
    }
    Integer poll = q.poll();

    ListQueue<Integer> lq = new ListQueue<>();
    System.out.println(lq.isEmpty());
    System.out.println(lq.size());
    lq.offer(10);
    lq.offer(20);
    lq.offer(30);

    while(!lq.isEmpty()) {
      System.out.println(lq.poll() + "이 리스트큐에서 삭제됨");
    }
    lq.poll();

  }
}
