package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private String selectedShape = "Линия"; // фигура по умолчанию
    public List<IDrawFigure> figures = new ArrayList<>();
    private int startX, startY, endX, endY;
    private int customRadius = 50; // радиус по умолчанию
    private Color selectedColor = Color.BLACK;

    public DrawPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                addFigure();
            }
        });
    }

    public void setSelectedShape(String shape) {
        if (shape.equals("Очистить")) {
            figures.clear();
            repaint();
        } else {
            this.selectedShape = shape;
        }
    }

    public void setCircleRadius(String radiusText) {
        try {
            customRadius = Integer.parseInt(radiusText);
            selectedShape = "Окружность"; // Выбираем режим рисования окружности
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Введите корректный радиус!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addFigure() {
        IDrawFigure figure = null;

        switch (selectedShape) {
            case "Линия":
                figure = new LineBuilder()
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .build();
                break;

            case "Квадрат":
                figure = new RectangleBuilder()
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .build();
                break;

            case "Круг":
                figure = new CircleBuilder()
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .build();
                break;

            case "Овал":
                figure = new OvalBuilder()
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .build();
                break;

            case "Окружность":
                figure = new CircleBuilder()
                        .setFixedRadius(customRadius)
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .build();
                break;
        }

        if (figure != null) {
            figures.add(figure);
            repaint();
        }
    }

    public void setSelectedColor(Color color) {
        this.selectedColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawFigure figure : figures) {
            figure.draw(g);
        }
    }
}
