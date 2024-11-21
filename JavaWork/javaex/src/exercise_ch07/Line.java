package exercise_ch07;

public class Line implements Comparable{
  int length ;
  public Line(int length){
    this.length = length;
  }

  @Override
  public int compareTo(Object o) {
    if(o instanceof Line) {
      Line line = (Line)o;
      int result;
      if(this.length < line.length) result = -1;
      else if (this.length > line.length) result = 1;
      else result = 0;
      return result;
    }
    return -999;
  }

  @Override
  public String toString() {
    return "Line[" +
        "length=" + length +
        ']';
  }
}

