package views;

import controllers.PaintBrush;
import models.builders.CircleBuilder;
import models.builders.LineBuilder;
import models.builders.OvalBuilder;
import models.builders.RectangleBuilder;
import models.figures.IDrawFigure;
import models.strategy.NormalStyle;
import models.strategy.PaintStyleStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private String selectedShape = "Кисть"; // фигура по умолчанию
    public List<IDrawFigure> figures = new ArrayList<>();
    private int startX, startY, endX, endY;
    private int customRadius = 50; // радиус по умолчанию
    private Color selectedColor = Color.BLACK;
    private PaintBrush currentBrushStyle = null;
    private PaintStyleStrategy selectedStyle = new NormalStyle();

    public DrawPanel() {
        setBackground(Color.WHITE);

        // слушатель нажатия и отпускания мышки
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();

                if (selectedShape.equals("Кисть") || selectedShape.equals("Ластик")) {
                    Color colorToUse = selectedShape.equals("Ластик") ? Color.WHITE : selectedColor;
                    currentBrushStyle = new PaintBrush(colorToUse, selectedStyle);
                    currentBrushStyle.addPoint(startX, startY);
                    figures.add(currentBrushStyle);
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();

                if (!selectedShape.equals("Кисть") && !selectedShape.equals("Ластик")) {
                    addFigure();
                } else {
                    currentBrushStyle = null;
                }
            }
        });

        // слушатель движения мышки
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if ((selectedShape.equals("Кисть") || selectedShape.equals("Ластик")) && currentBrushStyle != null) {
                    currentBrushStyle.addPoint(e.getX(), e.getY());
                    repaint();
                }
            }
        });
    }

    public void setSelectedShape(String shape) {
        if (shape.equals("Очистить лист")) {
            figures.clear();
            repaint();
        } else {
            this.selectedShape = shape;
        }
    }

    public void setCircleRadius(String radiusText) {
        try {
            customRadius = Integer.parseInt(radiusText);
            selectedShape = "Окружность"; // выбираем режим рисования окружности
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
                        .setStyle(selectedStyle)
                        .build();
                break;

            case "Квадрат":
                figure = new RectangleBuilder()
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .setStyle(selectedStyle)
                        .build();
                break;

            case "Круг":
                figure = new CircleBuilder()
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .setStyle(selectedStyle)
                        .build();
                break;

            case "Овал":
                figure = new OvalBuilder()
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .setStyle(selectedStyle)
                        .build();
                break;

            case "Окружность":
                figure = new CircleBuilder()
                        .setFixedRadius(customRadius)
                        .setCoordinates(startX, startY, endX, endY)
                        .setColor(selectedColor)
                        .setStyle(selectedStyle)
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

    public void setSelectedStyle(PaintStyleStrategy style) {
        this.selectedStyle = style;
    }

    public String getSelectedShape() {
        return selectedShape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawFigure figure : figures) {
            figure.draw(g);
        }
    }
}
