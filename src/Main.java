import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static String savedPassword = "";
    private static boolean isPasswordSet = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lock Class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setLayout(new GridLayout(3,1));

        JLabel title = new JLabel("Welcome to locker Application",  SwingConstants.CENTER);

        JPanel keypadPanel = new JPanel(new GridLayout(3,3));
        JPasswordField passwordField = new JPasswordField(10);
        JButton enterButton = new JButton("Enter");
        JButton clearButton = new JButton("Clear");
        JLabel statusLabel = new JLabel("Enter Password", SwingConstants.CENTER);
        ImageIcon imageIcon = new ImageIcon("lock-512.png");

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    passwordField.setText(passwordField.getText() + button.getText());
                }
            });
            keypadPanel.add(button);
        }

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
            }
        });

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isPasswordSet) {
                    savedPassword = passwordField.getText();
                    isPasswordSet = true;
                    statusLabel.setText("Password Set");
                } else {
                    if (passwordField.getText().equals(savedPassword)) {
                        statusLabel.setText("Correct Password");
                    } else {
                        statusLabel.setText("Incorrect Password");
                    }
                }
                passwordField.setText("");
            }
        });

        frame.add(title);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(clearButton);
        inputPanel.add(passwordField);
        inputPanel.add(enterButton);
        inputPanel.add(statusLabel);

        frame.setIconImage(imageIcon.getImage());
        frame.add(keypadPanel, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}