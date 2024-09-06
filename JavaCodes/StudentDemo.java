class Student {
    String name;
    int rollNumber;

    // Constructor to initialize the student object
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // Method to display information about the student
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // Create multiple Student objects
        Student student1 = new Student("Alice", 101);
        Student student2 = new Student("Bob", 102);
        Student student3 = new Student("Charlie", 103);

        // Display information about each student
        System.out.println("Student 1:");
        student1.displayInfo();

        System.out.println("\nStudent 2:");
        student2.displayInfo();

        System.out.println("\nStudent 3:");
        student3.displayInfo();
    }
}
