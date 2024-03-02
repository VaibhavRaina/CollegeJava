class Bank {
    float getRateOfInterest(float rate) {
        return rate;
    }
}

class SBI extends Bank {
    float getRateOfInterest() {
        return 8;
    }
}

class ICICI extends Bank {
    float getRateOfInterest() {
        return 7;
    }
}

class AXIS extends Bank {
    float getRateOfInterest() {
        return 9;
    }
}

public class p1 {
    public static void main(String[] args) {
        SBI s = new SBI();
        ICICI i = new ICICI();
        AXIS a = new AXIS();
        System.out.println(s.getRateOfInterest());
        System.out.println(i.getRateOfInterest());
        System.out.println(a.getRateOfInterest());
    }
}
