package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private double num1 = 0;
    private double num2 = 0;
    private char operator = ' ';
    private boolean isOperatorClicked = false;

    // Define colors
    private final Color FRAME_BG_COLOR = new Color(240, 240, 240); // Light gray
    private final Color TEXT_FIELD_BG_COLOR = Color.WHITE;
    private final Color TEXT_FIELD_FG_COLOR = Color.BLACK;
    private final Color PANEL_BG_COLOR = new Color(230, 230, 230); // Slightly darker gray
    private final Color NUMBER_BUTTON_BG_COLOR = Color.WHITE;
    private final Color OPERATOR_BUTTON_BG_COLOR = new Color(150, 200, 255); // Light blue
    private final Color EQUALS_BUTTON_BG_COLOR = new Color(150, 255, 150); // Light green
    private final Color CLEAR_BUTTON_BG_COLOR = new Color(255, 150, 150); // Light red
    private final Color BUTTON_FG_COLOR = Color.BLACK; // Common text color for buttons

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(400, 500); // Let pack() handle sizing
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(FRAME_BG_COLOR); // Set frame background

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.BOLD, 24)); // Make font bold
        textField.setBackground(TEXT_FIELD_BG_COLOR); // Set text field background
        textField.setForeground(TEXT_FIELD_FG_COLOR); // Set text field text color
        textField.setEditable(false);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1), // Outer border
            BorderFactory.createEmptyBorder(10, 10, 10, 10)    // Inner padding
        ));
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10)); // Rows, Cols, HGap, VGap
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(PANEL_BG_COLOR); // Set panel background

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20)); // Make button font bold
            button.setForeground(BUTTON_FG_COLOR); // Set common button text color

            switch (label) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    button.setBackground(NUMBER_BUTTON_BG_COLOR);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    button.setBackground(OPERATOR_BUTTON_BG_COLOR);
                    break;
                case "=":
                    button.setBackground(EQUALS_BUTTON_BG_COLOR);
                    break;
                case "C":
                    button.setBackground(CLEAR_BUTTON_BG_COLOR);
                    break;
            }
            button.addActionListener(this);
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.pack(); // Adjusts frame size to fit components
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    if (isOperatorClicked) {
                        textField.setText(command);
                        isOperatorClicked = false;
                    } else {
                        // Append to existing text, clear if it's an error message
                        if (textField.getText().startsWith("Error")) {
                            textField.setText(command);
                        } else {
                            textField.setText(textField.getText() + command);
                        }
                    }
                    break;

                case "+":
                case "-":
                case "*":
                case "/":
                    // If an operator is clicked after another operator, update the operator
                    if (!textField.getText().isEmpty() && !isOperatorClicked) {
                         if (operator != ' ') { // If there was a previous operator and number
                             num2 = Double.parseDouble(textField.getText());
                             performCalculation(); // Perform previous calculation first
                             textField.setText(String.valueOf(num1)); // Display intermediate result
                         } else { // First number entered
                             num1 = Double.parseDouble(textField.getText());
                         }
                    } else if (textField.getText().startsWith("Error")) {
                        // If an operator is pressed after an error, do nothing or clear? Let's allow clearing first.
                        return;
                    } else if (textField.getText().isEmpty() && operator != ' ') {
                        // If operator is pressed again without a number, just change operator
                         operator = command.charAt(0);
                         return;
                    } else if (textField.getText().isEmpty()) {
                        // Handle cases where operator is pressed first without any number
                        return;
                    }
                    
                    num1 = Double.parseDouble(textField.getText()); // Store the first number
                    operator = command.charAt(0);
                    isOperatorClicked = true;
                    break;

                case "=":
                    performCalculation();
                    break;

                case "C":
                    textField.setText("");
                    num1 = 0;
                    num2 = 0;
                    operator = ' ';
                    isOperatorClicked = false;
                    break;
            }
        } catch (NumberFormatException ex) {
            textField.setText("Error: Invalid Input");
            resetCalculatorState();
        } catch (Exception ex) {
            textField.setText("Error");
            ex.printStackTrace(); // For debugging purposes
            resetCalculatorState();
        }
    }

    // Helper method to perform calculation
    private void performCalculation() {
        if (operator == ' ') { // No operator selected yet
            return;
        }
        if (textField.getText().isEmpty() || textField.getText().startsWith("Error")) { // If '=' is pressed after an operator without a second number or after error
            return;
        }
        num2 = Double.parseDouble(textField.getText());
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    textField.setText("Error: Div by zero");
                    resetCalculatorState();
                    return;
                }
                result = num1 / num2;
                break;
        }
        // Format result to avoid trailing .0 for integers
        if (result == (long) result) {
            textField.setText(String.format("%d", (long) result));
        } else {
            textField.setText(String.valueOf(result));
        }
        
        num1 = result; // Allow chaining operations
        operator = ' ';
        isOperatorClicked = false;
    }
    
    // Helper method to reset calculator state
    private void resetCalculatorState() {
        num1 = 0;
        num2 = 0;
        operator = ' ';
        isOperatorClicked = false;
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}