import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {

    private JFrame frame;
    private JTextField textField;
    private double first, second, result;
    private String operation;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new Calculator().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(376, 576);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
    }

    public void initialize() {
        textField = createTextField();
        frame.getContentPane().add(textField);

        createRadioButtons();
        createButtons();

        frame.setVisible(true);
    }

    private JTextField createTextField() {
        JTextField tf = new JTextField();
        tf.setHorizontalAlignment(SwingConstants.RIGHT);
        tf.setFont(new Font("Tahoma", Font.PLAIN, 32));
        tf.setBounds(12, 13, 348, 82);
        tf.setColumns(10);
        return tf;
    }

    private void createRadioButtons() {
        ButtonGroup btg = new ButtonGroup();

        JRadioButton onButton = createRadioButton("On", 12, 108, 74, 32, true);
        JRadioButton offButton = createRadioButton("Off", 12, 145, 74, 32, false);

        btg.add(onButton);
        btg.add(offButton);

        onButton.addActionListener(e -> setCalculatorState(true));
        offButton.addActionListener(e -> setCalculatorState(false));
    }

    private JRadioButton createRadioButton(String text, int x, int y, int width, int height, boolean selected) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        radioButton.setBounds(x, y, width, height);
        radioButton.setSelected(selected);
        frame.getContentPane().add(radioButton);
        return radioButton;
    }

    private void setCalculatorState(boolean state) {
        frame.setEnabled(state);
        textField.setEnabled(state);

        Component[] components = frame.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                component.setEnabled(state);
            }
        }
    }

    private void createButtons() {
        createButton("<-", 94, 108, 72, 69, this::backspace);
        createButton("C", 178, 108, 85, 69, () -> textField.setText(null));
        createOperationButton("+", 275, 108, 85, 69, "+");

        for (int i = 1; i <= 9; i++) {
            createDigitButton(String.valueOf(i), (i - 1) % 3 * 97, 190 + (i - 1) / 3 * 88, 85, 75);
        }

        createOperationButton("-", 297, 190, 63, 75, "-");
        createDigitButton("0", 12, 454, 56, 75);
        createOperationButton("*", 297, 278, 63, 75, "x");
        createOperationButton("/", 297, 366, 63, 75, "/");
        createButton("%", 149, 454, 74, 75, () -> performOperation("%"));
        createButton(".", 81, 454, 56, 75, () -> textField.setText(textField.getText() + "."));

        JButton equalsButton = createButton("=", 236, 454, 124, 75, this::calculateResult);
        equalsButton.setFont(new Font("Tahoma", Font.BOLD, 28));
    }

    private void createOperationButton(String label, int x, int y, int width, int height, String op) {
        createButton(label, x, y, width, height, () -> performOperation(op));
    }

    private void createDigitButton(String label, int x, int y, int width, int height) {
        createButton(label, x, y, width, height, () -> textField.setText(textField.getText() + label));
    }

    private JButton createButton(String label, int x, int y, int width, int height, Runnable action) {
        JButton button = new JButton(label);
        button.addActionListener(e -> action.run());
        button.setFont(new Font("Tahoma", Font.BOLD, 22));
        button.setBounds(x, y, width, height);
        frame.getContentPane().add(button);
        return button;
    }

    private void backspace() {
        String text = textField.getText();
        if (text.length() > 0) {
            textField.setText(text.substring(0, text.length() - 1));
        }
    }

    private void performOperation(String op) {
        try {
            first = Double.parseDouble(textField.getText());
            textField.setText("");
            operation = op;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateResult() {
        try {
            second = Double.parseDouble(textField.getText());
            switch (operation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "x":
                    result = first * second;
                    break;
                case "/":
                    result = first / second;
                    break;
                case "%":
                    result = first % second;
                    break;
            }
            textField.setText(String.format("%.2f", result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
