import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

            outputArea.append("📍 Divisors of " + a + ": " + getDivisors(a) + "\n");
            outputArea.append("📍 Divisors of " + b + ": " + getDivisors(b) + "\n");
            outputArea.append("📍 Divisors of " + c + ": " + getDivisors(c) + "\n");

            int gcdValue = gcd(gcd(a, b), c);
            outputArea.append("\n✅ GCD of " + a + ", " + b + ", and " + c + " is: " + gcdValue);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "❌ Please enter valid integers in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getDivisors(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Math.abs(num); i++) {
            if (num % i == 0) {
                sb.append(i).append(" ");
            }
        }
        return sb.toString();
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DivisorsAndGCDGUI());
    }
}
