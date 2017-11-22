public class Car {
    String name;

    public Car(String name) {
        System.out.println("Car created " + name );
        this.name = name;
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car);
    }

    public void follow(final Car anotherCar) {
        System.out.println("Following the "+ anotherCar.name);
    }

    public void repair() {
        System.out.println("Repaired " + this.name);
    }
}
