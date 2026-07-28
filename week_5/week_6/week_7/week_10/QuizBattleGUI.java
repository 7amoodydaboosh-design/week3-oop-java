import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class QuizBattleGUI extends JFrame implements ActionListener {

    private JLabel bossLabel;
    private JLabel playerLabel;
    private JLabel scoreLabel;
    private JLabel questionLabel;

    private JButton[] answerButtons = new JButton[4];

    private Questions[] questions;

    private int currentQuestion = 0;
    private int bossHP = 100;
    private int playerHP = 100;
    private int score = 0;

    public QuizBattleGUI() {

        setTitle("Quiz Battle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 3));

        bossLabel = new JLabel("Boss HP: " + bossHP, SwingConstants.CENTER);
        playerLabel = new JLabel("Player HP: " + playerHP, SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);

        topPanel.add(bossLabel);
        topPanel.add(playerLabel);
        topPanel.add(scoreLabel);

        add(topPanel, BorderLayout.NORTH);

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(questionLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].addActionListener(this);
            buttonPanel.add(answerButtons[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);

        createQuestions();
        displayQuestion();

        setVisible(true);
    }

    private void createQuestions() {

        questions = new Questions[]{

                new Questions(
                        "Which keyword is used to create an object?",
                        new String[]{"class", "new", "void", "this"},
                        1
                ),

                new Questions(
                        "Java is a ______.",
                        new String[]{"Programming Language", "Browser", "Database", "Operating System"},
                        0
                ),

                new Questions(
                        "Which method starts a Java program?",
                        new String[]{"run()", "main()", "start()", "execute()"},
                        1
                ),

                new Questions(
                        "Which symbol ends a Java statement?",
                        new String[]{".", ",", ";", ":"},
                        2
                ),

                new Questions(
                        "Which company developed Java?",
                        new String[]{"Microsoft", "Apple", "Sun Microsystems", "Google"},
                        2
                )

        };
    }

    private void displayQuestion() {

        if (currentQuestion >= questions.length) {

            JOptionPane.showMessageDialog(this,
                    "Quiz Finished!\nFinal Score: " + score);

            System.exit(0);
        }

        Questions q = questions[currentQuestion];

        questionLabel.setText(q.getQuestion());

        String[] choices = q.getChoices();

        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(choices[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 4; i++) {

            if (e.getSource() == answerButtons[i]) {
                checkAnswer(i);
                break;
            }

        }

    }

    private void checkAnswer(int answer) {

        Questions q = questions[currentQuestion];

        if (answer == q.getCorrectAnswer()) {

            bossHP -= 20;
            score += 10;

            if (bossHP <= 0) {

                bossHP = 0;
                updateLabels();

                JOptionPane.showMessageDialog(this,
                        "Congratulations!\nYou defeated the Code Boss!");

                System.exit(0);
            }

        } else {

            playerHP -= 10;

            if (playerHP <= 0) {

                playerHP = 0;
                updateLabels();

                JOptionPane.showMessageDialog(this,
                        "Game Over!");

                System.exit(0);
            }
        }

        currentQuestion++;

        updateLabels();

        displayQuestion();
    }

    private void updateLabels() {

        bossLabel.setText("Boss HP: " + bossHP);
        playerLabel.setText("Player HP: " + playerHP);
        scoreLabel.setText("Score: " + score);

    }

    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            runConsoleQuiz();
        } else {
            SwingUtilities.invokeLater(() -> new QuizBattleGUI());
        }
    }

    private static void runConsoleQuiz() {
        Questions[] questions = new Questions[]{
                new Questions(
                        "Which keyword is used to create an object?",
                        new String[]{"class", "new", "void", "this"},
                        1
                ),
                new Questions(
                        "Java is a ______.",
                        new String[]{"Programming Language", "Browser", "Database", "Operating System"},
                        0
                ),
                new Questions(
                        "Which method starts a Java program?",
                        new String[]{"run()", "main()", "start()", "execute()"},
                        1
                ),
                new Questions(
                        "Which symbol ends a Java statement?",
                        new String[]{".", ",", ";", ":"},
                        2
                ),
                new Questions(
                        "Which company developed Java?",
                        new String[]{"Microsoft", "Apple", "Sun Microsystems", "Google"},
                        2
                )
        };

        Scanner scanner = new Scanner(System.in);
        int currentQuestion = 0;
        int bossHP = 100;
        int playerHP = 100;
        int score = 0;

        while (currentQuestion < questions.length) {
            Questions q = questions[currentQuestion];

            System.out.println("\nQuestion " + (currentQuestion + 1) + ": " + q.getQuestion());
            String[] choices = q.getChoices();
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i + 1) + ". " + choices[i]);
            }

            System.out.print("Your answer (1-4): ");
            int answer;
            try {
                answer = Integer.parseInt(scanner.nextLine().trim()) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            if (answer < 0 || answer >= 4) {
                System.out.println("Invalid answer. Please enter a number between 1 and 4.");
                continue;
            }

            if (answer == q.getCorrectAnswer()) {
                bossHP -= 20;
                score += 10;
                System.out.println("Correct! Boss takes 20 damage.");
                if (bossHP <= 0) {
                    bossHP = 0;
                    System.out.println("\nCongratulations! You defeated the Code Boss!");
                    break;
                }
            } else {
                playerHP -= 10;
                System.out.println("Wrong! Player takes 10 damage.");
                if (playerHP <= 0) {
                    playerHP = 0;
                    System.out.println("\nGame Over! You were defeated.");
                    break;
                }
            }

            currentQuestion++;
            System.out.println("Boss HP: " + bossHP + " | Player HP: " + playerHP + " | Score: " + score);
        }

        if (currentQuestion >= questions.length && bossHP > 0 && playerHP > 0) {
            System.out.println("\nQuiz Finished! Final Score: " + score);
        }
        scanner.close();
    }

}