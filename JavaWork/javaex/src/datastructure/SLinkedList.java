package datastructure;

public class SLinkedList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size;

  public SLinkedList() {
    head = tail = null;
    size = 0;
  }
  // 탐색, 삽입, 삭제 , size 를 구하는 메서드 구현
  int size() {
    return size;
  }

  void addLast(E e){
    Node<E> newNode = new Node<>();
    newNode.e = e;
    newNode.next = tail;
    if(size == 0) { // head == tail && head == null
      head = newNode;
    } else {
      getNode(size - 1).next = newNode;
    }
    tail = newNode;
    size++;
  }

  void addFirst(E e){
    // 1단계
    Node<E> newNode = new Node<E>();
    newNode.e = e;
    newNode.next = head;
    // 2단계
    if(size == 0) {
      tail = newNode;
    }
    head = newNode;
    // 3단계
    size++;
  }

  E getValue(int index){
    Node<E> find = head;
    for (int i = 0; i < index; i++) {
      find = find.next;
    }
    return find.e;
  }

  Node<E> getNode(int index){
    Node<E> find = head;
    System.out.println(find.e);
    for (int i = 0; i < index; i++) {
      System.out.println(find.e);
      find = find.next;
    }
    return find;
  }

  E removeLast() {
    Node<E> removedNode = tail;
    if(size>1) {
      Node<E> previousNode = getNode(size - 2);
      previousNode.next = null;
      tail = previousNode;
    } else if (size == 1) {
      head = tail = null;
    }
    size--;
    return removedNode.e;
  }

  E removeFirst() {
    Node<E> removedNode = head;
    head = head.next;
    removedNode.next = null;
    if (size == 1) {
      head = tail = null;
    }
    size--;
    return removedNode.e;
  }

  private class Node<E> {
    E e;
    Node<E> next;
  }
}

