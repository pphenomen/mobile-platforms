package views;

import controllers.DrawController;
import models.strategy.DashedStyle;
import models.strategy.NormalStyle;
import models.strategy.ThickStyle;

import javax.swing.*;
import java.awt.*;

public class DrawEditor extends JFrame {
    private DrawPanel drawPanel;
    private DrawController controller;
    private JTextField radiusField;
    private JComboBox<String> colorBox, styleBox;
    private final Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA};

    public DrawEditor() {
        setTitle("Графический редактор");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawPanel = new DrawPanel();
        controller = new DrawController(drawPanel, drawPanel.getFigures());
        add(drawPanel, BorderLayout.CENTER);

        add(createBottomPanel(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(createToolPanel(), BorderLayout.WEST);
        bottomPanel.add(createSettingsPanel(), BorderLayout.CENTER);
        bottomPanel.add(createActionPanel(), BorderLayout.EAST);
        return bottomPanel;
    }

    private JPanel createToolPanel() {
        JPanel toolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolPanel.setBorder(BorderFactory.createTitledBorder("Инструменты"));

        String[] tools = {"Кисть", "Линия", "Прямоугольник", "Круг", "Овал", "Ластик"};
        for (String tool : tools) {
            JButton button = new JButton(tool);
            button.addActionListener(e -> {
                controller.setSelectedShape(tool);
                resetDashedStyleIfNeeded(tool);
            });
            toolPanel.add(button);
        }
        return toolPanel;
    }

    private JPanel createSettingsPanel() {
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        settingsPanel.setBorder(BorderFactory.createTitledBorder("Настройки"));

        String[] styles = {"Обычная", "Толстая", "Пунктир"};
        styleBox = new JComboBox<>(styles);
        styleBox.addActionListener(e -> applySelectedStyle());

        settingsPanel.add(new JLabel("Толщина:"));
        settingsPanel.add(styleBox);

        String[] colorNames = {"Черный", "Красный", "Зелёный", "Синий", "Оранжевый", "Фиолетовый"};
        colorBox = new JComboBox<>(colorNames);
        colorBox.addActionListener(e -> {
            int selectedIndex = colorBox.getSelectedIndex();
            controller.setSelectedColor(colors[selectedIndex]);
        });

        settingsPanel.add(new JLabel("Цвет:"));
        settingsPanel.add(colorBox);

        radiusField = new JTextField(5);
        JButton circleButton = new JButton("Окружность");
        circleButton.addActionListener(e -> controller.setCircleRadius(radiusField.getText()));

        JPanel radiusPanel = new JPanel();
        radiusPanel.add(new JLabel("Радиус:"));
        radiusPanel.add(radiusField);
        radiusPanel.add(circleButton);
        settingsPanel.add(radiusPanel);

        return settingsPanel;
    }

    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actionPanel.setBorder(BorderFactory.createTitledBorder("Действия"));

        JButton clearButton = new JButton("Очистить лист");
        clearButton.setBackground(Color.LIGHT_GRAY);
        clearButton.addActionListener(e -> controller.setSelectedShape("Очистить лист"));
        actionPanel.add(clearButton);

        return actionPanel;
    }

    private void applySelectedStyle() {
        int selected = styleBox.getSelectedIndex();
        String currentShape = controller.getSelectedShape();

        if (selected == 2 && (currentShape.equals("Кисть") || currentShape.equals("Ластик"))) {
            JOptionPane.showMessageDialog(this, "Пунктир недоступен для кисти и ластика.", "Ограничение", JOptionPane.WARNING_MESSAGE);
            styleBox.setSelectedIndex(0);
            controller.setSelectedStyle(new NormalStyle());
            return;
        }

        switch (selected) {
            case 0 -> controller.setSelectedStyle(new NormalStyle());
            case 1 -> controller.setSelectedStyle(new ThickStyle());
            case 2 -> controller.setSelectedStyle(new DashedStyle());
        }
    }

    private void resetDashedStyleIfNeeded(String tool) {
        if ((tool.equals("Кисть") || tool.equals("Ластик")) && styleBox.getSelectedIndex() == 2) {
            styleBox.setSelectedIndex(0);
            controller.setSelectedStyle(new NormalStyle());
        }
    }
}
