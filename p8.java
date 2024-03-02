import java.util.*;

class person {
    String name;
    String address;
}

class Student extends person {
    ArrayList<String> Course = new ArrayList<>();
    ArrayList<Integer> Grades = new ArrayList<>();

    void addCourse(String course) {

        Course.add(course);
    }

    void addGrade(int grade) {

        Grades.add(grade);
    }

    float Average() {
        float sum = 0f;
        for (int i = 0; i < Grades.size(); i++) {
            sum = sum + Grades.get(i);
        }
        float avg = sum / Grades.size();
        return avg;
    }

    Student addStudent(Student s) {
        Scanner sc = new Scanner(System.in);
        int subject, grade;
        System.out.println("Enter name");
        s.name = sc.next();
        System.out.println("Enter address");
        s.address = sc.next();
        System.out.println("Add the number of subjects you want to add for this student It SHOULD NOT EXCEED 30");
        subject = sc.nextInt();
        if (subject >= 30) {
            System.out.println("Courses can not be greater than 30 !!");
            return null;
        } else {
            for (int i = 0; i < subject; i++) {
                System.out.println("Enter the course you want to add");
                s.addCourse(sc.next());
                System.out.println("Enter the grade for the above course student out of 100");
                grade = sc.nextInt();
                if (grade > 100) {
                    System.out.println("Grade can be more than 100");
                } else {
                    s.addGrade(grade);
                }
            }
        }
        return s;
    }

}

class Teacher extends person {
    ArrayList<String> courseTaught = new ArrayList<>();

    void addCourse(String course) {

        courseTaught.add(course);
    }

    void removeCourse(String course) {

        courseTaught.remove(course);
    }

    Teacher addTeacher(Teacher t) {
        Scanner sc = new Scanner(System.in);
        int subject;
        int label;
        System.out.println("Enter name");
        t.name = sc.next();
        System.out.println("Enter address");
        t.address = sc.next();
        System.out.println("Add the number of subjects you have taught to student It SHOULD NOT EXCEED 4");
        subject = sc.nextInt();
        if (subject >= 4) {
            System.out.println("Courses can not be greater than 30 !!");
            return null;
        } else {
            for (int i = 0; i < subject; i++) {
                System.out.println("Enter 1 to add course and 0 to Remove course");
                label = sc.nextInt();
                if (label == 1) {
                    if (t.courseTaught.size() >= 4) {
                        System.out.println("Can not add more course");
                    } else {
                        int num;
                        System.out.println("Enter the number of course you have taught");
                        num = sc.nextInt();
                        for (int j = 0; j < num; j++) {
                            System.out.println("Enter the course you have taught");
                            t.addCourse(sc.next());
                        }
                    }
                } else if (label == 0) {
                    if (t.courseTaught.size() == 0) {
                        System.out.println("There is no course can not remove for nothing!");
                    } else {
                        int num;
                        System.out.println("Enter the course you want to remove");
                        num = sc.nextInt();
                        for (int j = 0; j < num; j++) {
                            System.out.println("Enter the course want to remove");
                            t.removeCourse(sc.next());
                        }

                    }
                }

            }
            return t;
        }

    }
}

public class p8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sData = 0;
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        System.out.println("Put 1 for Student and 2 for Teacher and 0 for exit");
        int label;
        label = sc.nextInt();
        if (label == 1) {
            System.out.println("Enter the number of student data you want to feed");
            sData = sc.nextInt();
            for (int i = 0; i < sData; i++) {
                Student s = new Student();
                students.add(s.addStudent(s));
            }

            System.out.println("Printing");
            for (Student student : students) {
                System.out.println("Name: " + student.name);
                System.out.println("Address: " + student.address);
                for (int i = 0; i < student.Course.size(); i++) {
                    System.out.println(student.Course.get(i) + "--" + student.Grades.get(i));
                }
                System.out.println("Average Grade: " + student.Average());
                System.out.println();
            }

        } else if (label == 2) {
            System.out.println("Enter the number of teacher data you want to feed");
            sData = sc.nextInt();
            for (int i = 0; i < sData; i++) {
                Teacher t = new Teacher();
                teachers.add(t.addTeacher(t));
            }

            System.out.println("Printing");
            for (Teacher teacher : teachers) {
                System.out.println("Name: " + teacher.name);
                System.out.println("Address: " + teacher.address);
                for (int i = 0; i < teacher.courseTaught.size(); i++) {
                    System.out.println(teacher.courseTaught.get(i));
                }
                System.out.println();
            }
        }

    }

}
