import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DivisorsAndGCDGUI extends JFrame {

    private JTextField input1, input2, input3;
    private JTextArea outputArea;
    private JButton computeButton;
    private final Color MAROON = new Color(128, 0, 0);
    private final Color WHITE = Color.WHITE;

    public DivisorsAndGCDGUI() {
        setTitle("Divisors and GCD Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
        setLayout(new BorderLayout(20, 20));
        setLocationRelativeTo(null);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 15));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        inputPanel.setBackground(MAROON);

        JLabel label1 = new JLabel("Enter first integer:");
        JLabel label2 = new JLabel("Enter second integer:");
        JLabel label3 = new JLabel("Enter third integer:");

        label1.setForeground(WHITE);
        label2.setForeground(WHITE);
        label3.setForeground(WHITE);

        input1 = new RoundedTextField(10);
        input2 = new RoundedTextField(10);
        input3 = new RoundedTextField(10);

        inputPanel.add(label1);
        inputPanel.add(input1);
        inputPanel.add(label2);
        inputPanel.add(input2);
        inputPanel.add(label3);
        inputPanel.add(input3);

        computeButton = new RoundedButton("Compute Divisors & GCD");
        getRootPane().setDefaultButton(computeButton);
        inputPanel.add(computeButton);
        inputPanel.add(new JLabel("")); // spacer

        add(inputPanel, BorderLayout.NORTH);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setMargin(new Insets(15, 20, 15, 20));
        outputArea.setBackground(WHITE);
        outputArea.setForeground(MAROON);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        add(scrollPane, BorderLayout.CENTER);

        // Action
        computeButton.addActionListener(e -> computeResults());

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
        SwingUtilities.invokeLater(DivisorsAndGCDGUI::new);
    }
}

// 🔶 Custom Rounded Button
class RoundedButton extends JButton {
    private static final Color MAROON = new Color(128, 0, 0);
    private static final Color WHITE = Color.WHITE;

    public RoundedButton(String label) {
        super(label);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setForeground(MAROON);
        setBackground(WHITE);
        setFont(getFont().deriveFont(Font.BOLD));
        setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);

        g2.setColor(MAROON);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50);

        g2.dispose();
        super.paintComponent(g);
    }
}

// 🔶 Custom Rounded Text Field
class RoundedTextField extends JTextField {
    private static final Color MAROON = new Color(128, 0, 0);
    private static final Color WHITE = Color.WHITE;

    public RoundedTextField(int columns) {
        super(columns);
        setOpaque(false);
        setBackground(WHITE);
        setForeground(MAROON);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(MAROON);
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        return new Insets(8, 12, 8, 12);  // Extra padding
    }
}
