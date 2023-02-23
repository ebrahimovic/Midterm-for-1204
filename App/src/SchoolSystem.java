import Student.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSystem {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Please enter an option:");
            System.out.println("1- Add a student");
            System.out.println("2- Display all students");
            System.out.println("3- Exit");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter a student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter a student age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Is the student international (y/n): ");
                    boolean isInternational = sc.nextLine().equals("y");

                    System.out.print("Enter a student's major: ");
                    String major = sc.nextLine();

                    Student student = new StudentData(name, age, isInternational, major);
                    students.add(student);

                    System.out.println("Student added.");
                    break;
                case 2:
                    if (students.size() == 0) {
                        System.out.println("No students added.");
                    } else {
                        for (Student s : students) {
                            System.out.println("Name: " + s.getName());
                            System.out.println("Age: " + s.getAge());
                            System.out.println("International: " + s.isInternational());
                            System.out.println("Major: " + s.getMajor());
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 3.");
                    break;
            }
        }

        sc.close();
    }

    public static class StudentData implements Student {
        public String name;
        public int age;
        public boolean isInternational;
        public String major;

        public StudentData(String name, int age, boolean isInternational, String major) {
            this.name = name;
            this.age = age;
            this.isInternational = isInternational;
            this.major = major;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getAge() {
            return age;
        }

        @Override
        public boolean isInternational() {
            return isInternational;
        }

        @Override
        public String getMajor() {
            return major;
        }
    }
}

