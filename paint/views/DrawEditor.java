package views;

import models.strategy.DashedStyle;
import models.strategy.NormalStyle;
import models.strategy.ThickStyle;

import javax.swing.*;
import java.awt.*;

public class DrawEditor extends JFrame {
    private DrawPanel drawPanel;
    private JTextField radiusField;
    private JComboBox<String> colorBox, styleBox;
    private final Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA};

    public DrawEditor() {
        setTitle("Графический редактор");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        add(createBottomPanel(), BorderLayout.SOUTH);
        setVisible(true);
    }

    // нижняя панель
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(createToolPanel(), BorderLayout.WEST);
        bottomPanel.add(createSettingsPanel(), BorderLayout.CENTER);
        bottomPanel.add(createActionPanel(), BorderLayout.EAST);
        return bottomPanel;
    }

    // панель инструментов
    private JPanel createToolPanel() {
        JPanel toolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolPanel.setBorder(BorderFactory.createTitledBorder("Инструменты"));

        String[] tools = {"Кисть", "Линия", "Прямоугольник", "Круг", "Овал", "Ластик"};
        for (String tool : tools) {
            JButton button = new JButton(tool);
            button.addActionListener(e -> {
                drawPanel.setSelectedShape(tool);
                resetDashedStyleIfNeeded(tool);
            });
            toolPanel.add(button);
        }
        return toolPanel;
    }

    // панель настроек
    private JPanel createSettingsPanel() {
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        settingsPanel.setBorder(BorderFactory.createTitledBorder("Настройки"));

        // стиль
        String[] styles = {"Обычная", "Толстая", "Пунктир"};
        styleBox = new JComboBox<>(styles);
        styleBox.addActionListener(e -> applySelectedStyle());

        settingsPanel.add(new JLabel("Толщина:"));
        settingsPanel.add(styleBox);

        // цвет
        String[] colorNames = {"Черный", "Красный", "Зелёный", "Синий", "Оранжевый", "Фиолетовый"};
        colorBox = new JComboBox<>(colorNames);
        colorBox.addActionListener(e -> {
            int selectedIndex = colorBox.getSelectedIndex();
            drawPanel.setSelectedColor(colors[selectedIndex]);
        });

        settingsPanel.add(new JLabel("Цвет:"));
        settingsPanel.add(colorBox);

        // радиус для окружности
        radiusField = new JTextField(5);
        JButton circleButton = new JButton("Окружность");
        circleButton.addActionListener(e -> drawPanel.setCircleRadius(radiusField.getText()));

        JPanel radiusPanel = new JPanel();
        radiusPanel.add(new JLabel("Радиус:"));
        radiusPanel.add(radiusField);
        radiusPanel.add(circleButton);
        settingsPanel.add(radiusPanel);

        return settingsPanel;
    }

    // панель действий
    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actionPanel.setBorder(BorderFactory.createTitledBorder("Действия"));

        JButton clearButton = new JButton("Очистить лист");
        clearButton.setBackground(Color.LIGHT_GRAY);
        clearButton.addActionListener(e -> drawPanel.setSelectedShape("Очистить лист"));
        actionPanel.add(clearButton);

        return actionPanel;
    }

    // применение стиля
    private void applySelectedStyle() {
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
    }

    private void resetDashedStyleIfNeeded(String tool) {
        if ((tool.equals("Кисть") || tool.equals("Ластик")) && styleBox.getSelectedIndex() == 2) {
            styleBox.setSelectedIndex(0);
            drawPanel.setSelectedStyle(new NormalStyle());
        }
    }
}
