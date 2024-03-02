abstract class Shape {
    String color;
    boolean isFilled;

    Shape() {
        color = "green";
        isFilled = true;
    }

    Shape(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    String getColor() {
        return color;
    }

    boolean getFilled() {
        return isFilled;
    }

    public String toString() {
        if (this.isFilled) {
            return "A shape with color " + color + " is filled";
        } else {
            return "A shape with color " + color + " is not filled";
        }
    }

    abstract double getArea();
}

final class Rectangle extends Shape {
    Rectangle() {
        super("blue", true);
    }

    int l, b;

    double getArea() {
        return l * b;
    }
}

public class p3 {
    public static void main(String args[]) {
        Rectangle r1 = new Rectangle();
        r1.setColor("red");
        System.out.println("Color: " + r1.getColor());
        r1.setFilled(false);
        System.out.println("Filled: " + r1.getFilled());
    }
}
