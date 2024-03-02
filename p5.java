class Car {
    int speed;
    double regularPrice;
    String color;

    Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    double getSalesPrice() {
        return regularPrice;
    }
}

class Truck extends Car {
    Truck() {
        super(30, 10000, "red");
        System.out.println("Truck");
    }

    int weight;

    double getSalesPrice(double price) {
        return regularPrice = price;
    }

    int discount(int weight) {
        if (weight > 2000) {
            return 10;
        } else {
            return 20;
        }
    }
}

class Ford extends Car {
    int year;
    int manufactureDiscount;

    Ford() {
        super(30, 10000, "red");
    }

    double getSalesPrice() {
        return super.getSalesPrice() - manufactureDiscount;
    }
}

class Sedan extends Car {
    int length;

    Sedan() {
        super(30, 10000, "red");
    }

    double getSalesPrice(double price) {
        return regularPrice = price;
    }

    int discount(int length) {
        if (length > 20) {
            return 5;
        } else {
            return 10;
        }
    }
}

public class p5 {
    public static void main(String[] args) {
        Sedan s1 = new Sedan();
        Ford f1 = new Ford();
        Car c1 = new Car(30, 10000, "red");
        s1.getSalesPrice(10000);
        s1.length = 23;
        System.out.println(s1.discount(s1.length));
        f1.year = 2020;
        f1.manufactureDiscount = 10000;
        f1.getSalesPrice();
        c1.getSalesPrice();

    }
}
