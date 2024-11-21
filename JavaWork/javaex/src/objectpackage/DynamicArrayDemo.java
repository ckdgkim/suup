package objectpackage;

import java.util.ArrayList;

public class DynamicArrayDemo {
  public static void main(String[] args) {
    ArrayList<Object> numbers = new ArrayList<>();
    numbers.add("A");
    numbers.add("B");
    numbers.add("C");
    System.out.println(numbers);
    System.out.println(numbers.size());

    ArrayList<Circle> circles = new ArrayList<>();
    System.out.println(circles.size());
    circles.add(new Circle(1));
    System.out.println(circles.size());
    circles.add(new Circle(2));
    System.out.println(circles);
    System.out.println(circles.size());

    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(10);
    nums.add(20);
    nums.add(30);
    nums.add(40);
    System.out.println(nums.size());
    System.out.println(nums);

  }
}
