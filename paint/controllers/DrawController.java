package controllers;

import models.builders.*;
import models.figures.*;
import models.strategy.NormalStyle;
import models.strategy.PaintStyleStrategy;
import views.DrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DrawController {
    private final DrawPanel panel;
    private final List<IDrawFigure> figures;
    private String selectedShape = "Кисть";
    private int startX, startY, endX, endY;
    private int customRadius = 50;
    private Color selectedColor = Color.BLACK;
    private PaintStyleStrategy selectedStyle = new NormalStyle();
    private PaintBrush currentBrush = null;

    public DrawController(DrawPanel panel, List<IDrawFigure> figures) {
        this.panel = panel;
        this.figures = figures;
        setupMouseListeners();
    }

    private void setupMouseListeners() {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                if (selectedShape.equals("Кисть") || selectedShape.equals("Ластик")) {
                    Color colorToUse = selectedShape.equals("Ластик") ? Color.WHITE : selectedColor;
                    currentBrush = new PaintBrush(colorToUse, selectedStyle);
                    currentBrush.addPoint(startX, startY);
                    figures.add(currentBrush);
                    panel.repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                if (!selectedShape.equals("Кисть") && !selectedShape.equals("Ластик")) {
                    addFigure();
                } else {
                    currentBrush = null;
                }
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if ((selectedShape.equals("Кисть") || selectedShape.equals("Ластик")) && currentBrush != null) {
                    currentBrush.addPoint(e.getX(), e.getY());
                    panel.repaint();
                }
            }
        });
    }

    private void addFigure() {
        IDrawFigure figure = null;
        switch (selectedShape) {
            case "Линия" -> figure = new LineBuilder()
                    .setCoordinates(startX, startY, endX, endY)
                    .setColor(selectedColor)
                    .setStyle(selectedStyle)
                    .build();
            case "Прямоугольник" -> figure = new RectangleBuilder()
                    .setCoordinates(startX, startY, endX, endY)
                    .setColor(selectedColor)
                    .setStyle(selectedStyle)
                    .build();
            case "Круг" -> figure = new CircleBuilder()
                    .setCoordinates(startX, startY, endX, endY)
                    .setColor(selectedColor)
                    .setStyle(selectedStyle)
                    .build();
            case "Овал" -> figure = new OvalBuilder()
                    .setCoordinates(startX, startY, endX, endY)
                    .setColor(selectedColor)
                    .setStyle(selectedStyle)
                    .build();
            case "Окружность" -> figure = new CircleBuilder()
                    .setFixedRadius(customRadius)
                    .setCoordinates(startX, startY, endX, endY)
                    .setColor(selectedColor)
                    .setStyle(selectedStyle)
                    .build();
        }
        if (figure != null) {
            figures.add(figure);
            panel.repaint();
        }
    }

    public void setSelectedShape(String shape) {
        if (shape.equals("Очистить лист")) {
            figures.clear();
            panel.repaint();
        } else {
            this.selectedShape = shape;
        }
    }

    public void setCircleRadius(String radiusText) {
        try {
            customRadius = Integer.parseInt(radiusText);
            selectedShape = "Окружность";
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "Введите корректный радиус!", "Ошибка", JOptionPane.ERROR_MESSAGE);
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
}
