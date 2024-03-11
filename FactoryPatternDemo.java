interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw() Method");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle draw() Method");
    }
}

class Shape_Factory {
    public Shape create_shape(String shape_name) {
        if (shape_name == null) {
            return null;
        }
        if (shape_name.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shape_name.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shape_name.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square draw() Method");
    }
}

public class FactoryPatternDemo {
    public static void main(String args[]) {
        Shape s = new Square();
        s.draw();
        Shape c = new Circle();
        c.draw();
        Shape r = new Rectangle();
        r.draw();
    }
}
