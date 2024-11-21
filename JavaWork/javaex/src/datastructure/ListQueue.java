package datastructure;

public class ListQueue<E> {
  private Node<E> front;
  private Node<E> rear;
  private int size;
  public ListQueue(){
    front = rear = null;
    size = 0;
  }
  boolean isEmpty() {
    return (size == 0) ? true : false;
  }
  int size() {
    return size;
  }
  // poll,offer
  void offer(E e){
    Node<E> newNode = new Node<>();
    newNode.e = e;
    newNode.next = rear;
    if(size == 0) { // head == tail && head == null
      front = newNode;
    } else {
      getNode(size - 1).next = newNode;
    }
    rear = newNode;
    size++;
  }

  Node<E> getNode(int index){
    Node<E> find = front;
    System.out.println(find.e);
    for (int i = 0; i < index; i++) {
      System.out.println(find.e);
      find = find.next;
    }
    return find;
  }

  E poll() {
    if(isEmpty()) {
      return null;
    }
    Node<E> removedNode = front;
    front = front.next;
    removedNode.next = null;
    if (size == 1) {
      front = rear = null;
    }
    size--;
    return removedNode.e;
  }

  private class Node<E> {
    E e;
    Node<E> next;
  }
}
