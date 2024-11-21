package advancedJava;

public class GenericDemo1 {
  public static void main(String[] args) {
    CupBoricha cupBoricha = new CupBoricha();
    cupBoricha.setBeverage(new Boricha());
    Boricha beverage1 = cupBoricha.getBeverage();

    CupBeer cupBeer = new CupBeer();
    cupBeer.setBeverage(new Beer());
    Beer beverage2 = cupBeer.getBeverage();

//    Cup c = new Cup();
//    c.setBeverage(new Beer());
//    Object beverage = c.getBeverage();
//    Beer b = (Beer) beverage;
//    System.out.println(b.name);
//
//    c.setBeverage(new Boricha());
//    Object beverage3 = c.getBeverage();
//    Boricha bori = (Boricha) beverage3;
//    System.out.println(bori.name);

  }
}

class Beverage {}

class Boricha extends Beverage {
  String name = "보리차";
}

class Beer extends Beverage {
  String name = "맥주";
}

//class Cup{
//  private Object beverage;
//
//  public Object getBeverage() {
//    return beverage;
//  }
//
//  public void setBeverage(Object beverage) {
//    this.beverage = beverage;
//  }
//}

class CupBeer{
  private Beer beverage;

  public Beer getBeverage() {
    return beverage;
  }

  public void setBeverage(Beer beverage) {
    this.beverage = beverage;
  }
}

class CupBoricha{
  private Boricha beverage;

  public Boricha getBeverage() {
    return beverage;
  }

  public void setBeverage(Boricha beverage) {
    this.beverage = beverage;
  }
}

class CupBev {

}