package exercise_ch07;

public class Ex3_2 {
  public static void main(String[] args) {
    Triangle t1 = new Triangle(10,10);
    Triangle t2 = new Triangle(5,10);
    int result = t2.compareTo(t1);
    switch (result) {
      case 0 :
        System.out.println("동일하다");
        break;
      case -1 :
        System.out.print(t1);
        System.out.println("이 더 큽니다.");
        break;
      case 1 :
        System.out.print(t2);
        System.out.println("이 더 큽니다.");
        break;
      default:
        System.out.println("비교할 수 없습니다.");
    }
  }
}

class Triangle implements Comparable{
  int height, width;

  public Triangle(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public int compareTo(Object o) {
    if(o instanceof Triangle) {
      Triangle t = (Triangle) o;
      int result;
      if(this.getArea() < t.getArea())  result = -1;
      else if (this.getArea() > t.getArea()) result = 1;
      else result = 0;
      return result;
    }
    return -999;
  }

  public double getArea(){
    return (height * width) /(double) 2;
  }

  @Override
  public String toString() {
    return "삼각형[" +
        "width=" + width +
        ", height=" + height +
        ", 넓이=" + getArea()+
        ']';
  }
}
