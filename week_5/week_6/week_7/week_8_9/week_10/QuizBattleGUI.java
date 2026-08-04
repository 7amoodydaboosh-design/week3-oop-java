import javax.swing.*;
import java.awt.event.*;

public class QuizBattleGUI extends JFrame implements ActionListener {

    JLabel lblQuestion;
    JLabel lblResult;

    JButton btn1;
    JButton btn2;

    Questions question;

    public QuizBattleGUI() {

        setTitle("Programming Quiz Battle");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        question = new Questions();

        lblQuestion = new JLabel(question.getQuestion());
        lblQuestion.setBounds(30, 20, 320, 30);

        btn1 = new JButton(question.getOption1());
        btn1.setBounds(50, 80, 100, 40);

        btn2 = new JButton(question.getOption2());
        btn2.setBounds(220, 80, 100, 40);

        lblResult = new JLabel("Answer the question!");
        lblResult.setBounds(80, 150, 250, 30);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        add(lblQuestion);
        add(btn1);
        add(btn2);
        add(lblResult);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        if (question.isCorrect(button.getText())) {
            lblResult.setText("Correct! You defeated the Code Boss!");
        } else {
            lblResult.setText("Wrong! Try Again!");
        }
    }

    public static void main(String[] args) {
        new QuizBattleGUI();
    }
}