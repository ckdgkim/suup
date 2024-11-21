package advancedJava;

public class GenericDemo2 {
  public static void main(String[] args) {
    Cup<Beer> c1 = new Cup<>();

    c1.setBeverage(new Beer());
    Beer beer = c1.getBeverage();
    System.out.println(beer.name);

    Cup<Boricha> c2;
    //Cup<String>

    //c1.setBeverage(new Boricha());
  }
}

class Cup<T extends Beverage> {
  private T beverage;

  public T getBeverage() {
    return beverage;
  }

  public void setBeverage(T beverage) {
    this.beverage = beverage;
  }
}