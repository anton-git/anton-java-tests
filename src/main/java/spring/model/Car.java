package spring.model;

public class Car {

    private String make;

    {
        System.out.println("Car: before construct");
    }

    public Car() {
        System.out.println("Car: empty constructor");
    }

    public Car(String make) {
        System.out.println("Car: arg constructor");
        this.make = make;
    }

    public static Car getInstance() {
        System.out.println("Car: static builder without args");
        return new Car();
    }

    public static Car of(String make) {
        System.out.println("Car: static builder with args");
        return new Car(make);
    }

    public String getMake() {
        System.out.println("Car: getter");
        return make;
    }

    public void setMake(String make) {
        System.out.println("Car: setter");
        this.make = make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                '}';
    }
}
