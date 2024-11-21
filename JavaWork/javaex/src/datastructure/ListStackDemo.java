package datastructure;

public class ListStackDemo {
  public static void main(String[] args) {
    ListStack<String> stack = new ListStack<>();
    System.out.println(stack.isEmpty());
    System.out.println(stack.size());
    if(!stack.isEmpty())
      stack.peek();

    stack.push("A");
    stack.push("B");
    stack.push("C");

    while(!stack.isEmpty()) {
      System.out.println(stack.pop() + "이 제거되었습니다.");
    }

    stack.pop();
  }
}
