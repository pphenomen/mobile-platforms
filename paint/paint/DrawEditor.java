package paint;

import javax.swing.*;
import java.awt.*;

public class DrawEditor extends JFrame {
    private DrawPanel drawPanel;
    private JTextField radiusField;

    public DrawEditor() {
        setTitle("Графический редактор");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        String[] buttons = {"Линия", "Квадрат", "Круг", "Овал", "Очистить"};

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(e -> drawPanel.setSelectedShape(text));
            buttonPanel.add(button);
        }

        radiusField = new JTextField(5);
        JButton circleButton = new JButton("Окружность");
        circleButton.addActionListener(e -> drawPanel.setCircleRadius(radiusField.getText()));

        buttonPanel.add(new JLabel("Радиус:"));
        buttonPanel.add(radiusField);
        buttonPanel.add(circleButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawEditor();
    }
}
