package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private String selectedShape = "Линия";
    private List<IDrawFigure> figures = new ArrayList<>();
    private int startX, startY, endX, endY;
    private int customRadius = 50; // Радиус по умолчанию

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
        switch (selectedShape) {
            case "Линия":
                figures.add(new Line(startX, startY, endX, endY));
                break;
            case "Квадрат":
                figures.add(new RectangleShape(startX, startY, endX - startX, endX - startX));
                break;
            case "Круг":
                figures.add(new Circle(startX, startY, Math.abs(endX - startX)));
                break;
            case "Овал":
                figures.add(new Oval(startX, startY, Math.abs(endX - startX), Math.abs(endY - startY)));
                break;
            case "Окружность":
                figures.add(new Circle(startX - customRadius / 2, startY - customRadius / 2, customRadius));
                break;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawFigure figure : figures) {
            figure.draw(g);
        }
    }
}
