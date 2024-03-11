//The Bridge Pattern decouples an abstraction from its implementation, allowing them to vary //independently, promoting flexibility and extensibility in software design. It achieves this by //providing an interface to clients for both the abstraction and its implementation, which are //then linked through composition rather than inheritance.
// Interface for Workshop
interface Workshop {
    void work();
}

// Concrete implementation of Workshop: Produce
class Produce implements Workshop {
    @Override
    public void work() {
        System.out.print(" Producing");
    }
}

// Concrete implementation of Workshop: Assemble
class Assemble implements Workshop {
    @Override
    public void work() {
        System.out.print(" And");
        System.out.println(" Assembled");
    }
}

// Abstract class for Vehicle
abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop workshop1, Workshop workshop2) {
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    abstract void manufacture();
}

// Concrete class for Car
class Car extends Vehicle {
    public Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    void manufacture() {
        System.out.print("Manufacturing a car");
        workshop1.work();
        workshop2.work();
    }
}

// Concrete class for Bike
class Bike extends Vehicle {
    public Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    void manufacture() {
        System.out.print("Manufacturing a bike");
        workshop1.work();
        workshop2.work();
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Creating an instance of Car
        Vehicle car = new Car(new Produce(), new Assemble());
        car.manufacture();

        // Creating an instance of Bike
        Vehicle bike = new Bike(new Produce(), new Assemble());
        bike.manufacture();
    }
}