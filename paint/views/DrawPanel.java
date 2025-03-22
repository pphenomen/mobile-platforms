package views;

import models.figures.IDrawFigure;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private final List<IDrawFigure> figures = new ArrayList<>();

    public DrawPanel() {
        setBackground(Color.WHITE);
    }

    public List<IDrawFigure> getFigures() {
        return figures;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawFigure figure : figures) {
            figure.draw(g);
        }
    }
}
