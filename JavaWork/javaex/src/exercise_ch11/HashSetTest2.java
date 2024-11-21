package exercise_ch11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetTest2 {
  public static void main(String[] args) {
    Set<Student> set = new HashSet<>();

    set.add(new Student(1,"홍길동"));
    set.add(new Student(2,"손흥민"));
    set.add(new Student(1,"이강인"));

    System.out.println("저장된 객체의 수 : " + set.size());
    for (Student student : set) {
      System.out.println(student);
    }
  }
}

class Student {
  public int studentNum;
  public String name;

  public Student(int studentNum, String name) {
    this.studentNum = studentNum;
    this.name = name;
  }
  // 코드 작성
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student student)) return false;
    return studentNum == student.studentNum;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(studentNum);
  }

  @Override
  public String toString() {
    return "학생[" +
        studentNum +
        ", " + name +
        ']';
  }
}