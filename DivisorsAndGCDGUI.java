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
            int c = Integer.parseInt(input3.getText().tr
