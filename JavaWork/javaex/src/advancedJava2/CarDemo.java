package advancedJava2;

import java.util.Collections;
import java.util.Comparator;

public class CarDemo {
  public static void main(String[] args) {
    Car car = new Car("K3", true, 4, 25000);

    System.out.println(car);
    int cnt = 0;
    for (Car car1 : Car.cars) {
      if(car1.getModel().equals("소나타")) {
        cnt++;
      }
      System.out.println(car1);
    }
    System.out.println("소나타는 모두 " + cnt + " 대입니다.");

    Collections.sort(Car.cars, (car1, car2) -> car1.getAge() - car2.getAge());
//        new Comparator<Car>() {
//      @Override
//      public int compare(Car o1, Car o2) {
//        return o1.getAge() - o2.getAge();
//      }
//    });

    System.out.println(Car.cars);

    Collections.sort(Car.cars, (car1, car2) -> car2.getMileage() - car1.getMileage());
    System.out.println(Car.cars);

    Comparator<Car> modelComparator = Comparator.comparing(Car::getModel);
    Collections.sort(Car.cars, modelComparator);

    System.out.println(Car.cars);
  }
}
