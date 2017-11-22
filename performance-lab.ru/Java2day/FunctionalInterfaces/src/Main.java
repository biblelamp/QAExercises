import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        //Ссылка на конструктор класса
        CarFactory<Car> cf = Car::new; //ссылка на метод конструктора
        CarFactory<Car> cf1 = name -> new Car(name); //тоже самое, но описанное лямбда-функцией
        CarFactory<Car> cf2 = new CarFactory<Car>() { //то же самое, но через анонимно реализованный интерфейс
            @Override
            public Car create(String name) {
                return new Car(name);
            }
        };

        //создадим пару машин
        Car car1 = cf.create("car1");
        Car car2 = cf1.create("car2");
        List<Car> carList = Arrays.asList(car1, car2); //создадим лист из машин

        carList.forEach(Car::repair); //Ссылка на метод произвольного экземпляра класса
        carList.forEach(car -> car.repair()); //тоже самое, но описанное лямбда-функцией
        carList.forEach(new Consumer<Car>() { //то же самое, но через анонимно реализованный интерфейс
            @Override
            public void accept(Car car) {
                car.repair();
            }
        });

        carList.forEach(car2::follow); //Ссылка на метод конкретного объекта
        carList.forEach(car -> car.follow(car)); //тоже самое, но описанное лямбда-функцией

        carList.forEach(System.out::println); //Ссылка на статический метод
        carList.forEach(car -> System.out.println(car)); //тоже самое, но описанное лямбда-функцией
    }
}
