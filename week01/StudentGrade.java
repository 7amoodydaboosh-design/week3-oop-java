public class StudentGrade {

    public static void main(String[] args) {

        String studentName = "Ahmed";
        int mark = 85;

        System.out.println("Student Grade System");
        System.out.println("--------------------");
        System.out.println("Student Name: " + studentName);
        System.out.println("Mark: " + mark);

        if (mark >= 80) {
            System.out.println("Grade: A");
        } else if (mark >= 70) {
            System.out.println("Grade: B");
        } else if (mark >= 60) {
            System.out.println("Grade: C");
        } else if (mark >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}