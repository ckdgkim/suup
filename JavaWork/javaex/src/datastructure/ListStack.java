package datastructure;

import org.w3c.dom.Node;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class ListStack<E> {
  Node<E> top;
  int size;
  public ListStack(){
    top = null;
    size = 0;
  }
  boolean isEmpty() {
    return (size == 0) ? true : false;
  }
  int size() {
    return size;
  }
  // push, pop, peek 구현
  E peek() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }
    return top.e;
  }

  void push(E e){
    // 1단계
    Node<E> newNode = new Node<E>();
    newNode.e = e;
    newNode.next = top;
    // 2단계
    top = newNode;
    // 3단계
    size++;
  }

  E pop() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }
    Node<E> removedNode = top;
    top = top.next;
    removedNode.next = null;
    if (size == 1) {
      top = null;
    }
    size--;
    return removedNode.e;
  }

  private class Node<E> {
    E e;
    Node<E> next;
  }
}
