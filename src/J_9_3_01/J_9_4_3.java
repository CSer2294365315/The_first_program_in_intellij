package J_9_3_01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class J_9_4_3 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new TextComponentFrame();
            frame.setTitle("textTesting");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}

       class TextComponentFrame extends JFrame {
        public static final int TEXTAREA_ROWS = 8;
        public static final int TEXTAREA_COLUMNS = 20;

        public TextComponentFrame() {
            JTextField textField = new JTextField();
            JPasswordField passwordField = new JPasswordField();

            JPanel northPanel = new JPanel();
            northPanel.setLayout(new GridLayout(2, 2));
            northPanel.add(new JLabel("User name", SwingConstants.RIGHT));
            northPanel.add(textField);
            northPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
            northPanel.add(passwordField);

            add(northPanel, BorderLayout.NORTH);

            JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);

            JScrollPane scrollPane = new JScrollPane(textArea);

            add(scrollPane, BorderLayout.CENTER);

            JPanel southPanel = new JPanel();

            JButton insertButton = new JButton("insert");
            southPanel.add(insertButton);
            insertButton.addActionListener(event -> {
                textArea.append("User name:" + textField.getText() + " Passsord: " + new String(passwordField.getPassword()) + "\n");
            });

            add(southPanel, BorderLayout.SOUTH);
            pack();

        }

    }



