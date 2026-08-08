public class Main {

    public static void main(String[] args) {

        lecturer lec = new lecturer(
                "L100",
                "Dr Ahmad",
                "Java Programming",
                "Faculty of Information Technology"
        );

        lec.displayInfo();
        lec.displaySubject();
    }
}