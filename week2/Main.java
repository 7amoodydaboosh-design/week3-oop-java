public class Main {

    public static void main(String[] args) {

        // Create a Student object
        Student s1 = new Student("Ahmed", 20, 3.75);

        // Display student information
        s1.displayInfo();

        // Call the other methods
        s1.study();
        s1.takeExam();
    }
}