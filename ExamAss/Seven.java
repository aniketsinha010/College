package ExamAss;

abstract class Vehicle{
    abstract void start();
}

class Car extends Vehicle{
    @Override
    void start(){
        System.out.println("Car");
    }
}

class Bike extends Vehicle{
    @Override
    void start(){
        System.out.println("Bike");
    }
}

public class Seven {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();

        Bike bike = new Bike();
        bike.start();
    }
}