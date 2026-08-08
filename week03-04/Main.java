public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ahmed", "P001");
        Person p2 = new Student("Sara", "S002");
        Person p3 = new Lecturer("Khaled", "L003");

        p1.introduce();
        p2.introduce();
        p3.introduce();
    }
}