package exercise_ch06;

public class Ex2 {
  public static void main(String[] args) {
    Point p = new Point(3,4);
    System.out.println(p);

    MovablePoint mp = new MovablePoint(5,5,10,10);
    System.out.println(mp);
  }
}

class Point{
  // 필드
  private int x,y;
  // 생성자
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  // 메서드(getter, setter, toString)
  public int getX() { return x; }
  public void setX(int x)  { this.x = x;  }
  public int getY() { return y; }
  public void setY(int y) { this.y = y;}

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + "}";
  }
}

class MovablePoint extends Point {
  // 필드
  private int xSpeed, ySpeed;
  // 생성자
  public MovablePoint(int x, int y, int xSpeed, int ySpeed){
    super(x,y);
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }
  // 메서드(getter, setter, toString)
  public int getxSpeed() { return xSpeed; }
  public void setxSpeed(int xSpeed) { this.xSpeed = xSpeed; }
  public int getySpeed() { return ySpeed; }
  public void setySpeed(int ySpeed) { this.ySpeed = ySpeed; }

  @Override
  public String toString() {
    return "MovablePoint {x=" + super.getX() + ", y=" + super.getY() + "," +
        "xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "}";
  }
}
