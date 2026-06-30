public class Main {

    public static void main(String[] args) {

        sTudent student = new sTudent();

        student.setStudentID("CU12345");
        student.setName("Ali");
        student.setCGPA(3.75);
        student.setProgramme("BIT");

        System.out.println("Student ID : " + student.getStudentID());
        System.out.println("Name       : " + student.getName());
        System.out.println("CGPA       : " + student.getCGPA());
        System.out.println("Programme  : " + student.getProgramme());
    }
}