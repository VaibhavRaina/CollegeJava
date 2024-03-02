import java.util.Scanner;

abstract class Vehicle {
    boolean hashHelmet;
    int manufacture;

    Vehicle(boolean hashHelmet, int manufacture) {
        this.hashHelmet = hashHelmet;
        this.manufacture = manufacture;
    }

    abstract void getData();

    abstract void putData();
}

class twoWheeler extends Vehicle {
    Scanner sc = new Scanner(System.in);
    private String brand;
    protected int cost;
    int engineType = 2;
    public String color;

    twoWheeler() {
        super(true, 2023);
    }

    void getData() {
        hashHelmet = false;
        manufacture = 2022;
        System.out.println("Enter brand");
        brand = sc.next();
        System.out.println("Enter cost");
        cost = sc.nextInt();
        System.out.println("Enter color");
        color = sc.next();

    }

    void putData() {
        System.out.println("Brand-" + brand + " Cost-" + cost + " Engine type-" + engineType + " color" + color);
    }
}

final class fourWheeler extends Vehicle {
    fourWheeler() {
        super(true, 2013);
    }

    void putData() {
        hashHelmet = false;
        manufacture = 2022;
    }

    void getData() {
        System.out.println("hashhelmet--" + hashHelmet + "  manufacure date ---" + manufacture);
    }
}

public class p2 {
    public static void main(String[] args) {
        twoWheeler t1 = new twoWheeler();
        fourWheeler f1 = new fourWheeler();
        t1.getData();
        t1.putData();
        f1.getData();
        f1.putData();
    }
}
