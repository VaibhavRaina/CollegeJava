abstract class Student {
    String name;
    int id;
    int grade;
    int age;

    abstract Boolean isPassed(int grade);
}

class underGrad extends Student {
    Boolean isPassed(int grade) {
        if (grade > 70) {
            return true;
        } else {
            return false;
        }
    }

    final int getGrade() {
        return grade;
    }
}

class Grad extends Student {
    Boolean isPassed(int grade) {
        if (grade > 80) {
            return true;
        } else {
            return false;
        }
    }

    final int getGrade() {
        return grade;
    }
}

class test {
    test(int gGrade, int uGrade) {
        Grad g1 = new Grad();
        underGrad u1 = new underGrad();
        System.out.println(g1.isPassed(gGrade));
        System.out.println(u1.isPassed(uGrade));
    }

}

public class p4 {
    public static void main(String[] args) {
        test t1 = new test(80, 50);

    }
}