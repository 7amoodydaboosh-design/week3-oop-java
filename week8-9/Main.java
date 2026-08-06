import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // Add tasks
        System.out.println("===== ADD TASKS =====");

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter Task " + (i + 1) + ": ");
            String task = input.nextLine();
            tasks.add(task);
        }

        // Display task list
        System.out.println("\n===== TASK LIST =====");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        // Save tasks to task.txt
        try {
            FileWriter writer = new FileWriter("task.txt");

            for (String task : tasks) {
                writer.write(task + "\n");
            }

            writer.close();
            System.out.println("\nTasks saved successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Read tasks from task.txt
        System.out.println("\n===== TASKS LOADED FROM FILE =====");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("task.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}