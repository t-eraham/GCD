import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;

public class DivisorsAndGCDGUI extends JFrame {

    private JTextField input1, input2, input3;
    private JTextArea outputArea;
    private JButton computeButton;

    public DivisorsAndGCDGUI() {
        setTitle("Divisors and GCD Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 350);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Enter first integer:"));
        input1 = new JTextField();
        inputPanel.add(input1);

        inputPanel.add(new JLabel("Enter second integer:"));
        input2 = new JTextField();
        inputPanel.add(input2);

        inputPanel.add(new JLabel("Enter third integer:"));
        input3 = new JTextField();
        inputPanel.add(input3);

        computeButton = new JButton("Compute Divisors & GCD");
        inputPanel.add(computeButton);

        add(inputPanel, BorderLayout.NORTH);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setMargin(new Insets(10, 10, 10, 10));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Button Action
        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computeResults();
            }
        });

        setVisible(true);
    }

    private void computeResults() {
        outputArea.setText("");  // Clear output area
        try {
            int a = Integer.parseInt(input1.getText().trim());
            int b = Integer.parseInt(input2.getText().trim());
            int c = Integer.parseInt(input3.getText().trim());

            List<Integer> divisorsA = getDivisors(a);
            List<Integer> divisorsB = getDivisors(b);
            List<Integer> divisorsC = getDivisors(c);

            outputArea.append("Divisors of " + a + ": " + divisorsA + "\n");
            outputArea.append("Divisors of " + b + ": " + divisorsB + "\n");
            outputArea.append("Divisors of " + c + ": " + divisorsC + "\n\n");

            int gcd = computeGCD(a, computeGCD(b, c));
            outputArea.append("GCD of " + a + ", " + b + ", and " + c + ": " + gcd);
        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter valid integers.");
        }
    }

    private List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.abs(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    private int computeGCD(int x, int y) {
        if (y == 0) return Math.abs(x);
        return computeGCD(y, x % y);
    }
}
