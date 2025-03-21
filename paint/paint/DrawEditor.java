package paint;

import javax.swing.*;
import java.awt.*;

public class DrawEditor extends JFrame {
    private DrawPanel drawPanel;
    private JTextField radiusField;
    private JComboBox<String> colorBox;
    private final Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA};

    public DrawEditor() {
        setTitle("Графический редактор");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        String[] buttons = {"Кисть", "Линия", "Квадрат", "Круг", "Овал", "Ластик", "Очистить лист"};

        String[] styles = {"Обычная", "Толстая", "Пунктир"};
        JComboBox<String> styleBox = new JComboBox<>(styles);

        styleBox.addActionListener(e -> {
            int selected = styleBox.getSelectedIndex();
            String currentShape = drawPanel.getSelectedShape();

            if (selected == 2 && (currentShape.equals("Кисть") || currentShape.equals("Ластик"))) {
                JOptionPane.showMessageDialog(this, "Пунктир недоступен для кисти и ластика.", "Ограничение", JOptionPane.WARNING_MESSAGE);
                styleBox.setSelectedIndex(0);
                drawPanel.setSelectedStyle(new NormalStyle());
                return;
            }

            switch (selected) {
                case 0 -> drawPanel.setSelectedStyle(new NormalStyle());
                case 1 -> drawPanel.setSelectedStyle(new ThickStyle());
                case 2 -> drawPanel.setSelectedStyle(new DashedStyle());
            }
        });

        buttonPanel.add(new JLabel("Стиль:"));
        buttonPanel.add(styleBox);

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(e -> {
                drawPanel.setSelectedShape(text);

                // отключение пунктира для кисти и ластика
                if ((text.equals("Кисть") || text.equals("Ластик")) && styleBox.getSelectedIndex() == 2) {
                    styleBox.setSelectedIndex(0);
                    drawPanel.setSelectedStyle(new NormalStyle());
                }
            });

            buttonPanel.add(button);
        }

        String[] colorNames = {"Черный", "Красный", "Зелёный", "Синий", "Оранжевый", "Фиолетовый"};
        colorBox = new JComboBox<>(colorNames);
        colorBox.addActionListener(e -> {
            int selectedIndex = colorBox.getSelectedIndex();
            drawPanel.setSelectedColor(colors[selectedIndex]);
        });

        buttonPanel.add(new JLabel("Цвет:"));
        buttonPanel.add(colorBox);

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
