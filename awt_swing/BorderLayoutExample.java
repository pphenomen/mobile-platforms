package lab4_1;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Компоновка элементов");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JButton("Север"), BorderLayout.NORTH);
        panel.add(new JButton("Юг"), BorderLayout.SOUTH);
        panel.add(new JButton("Запад"), BorderLayout.WEST);
        panel.add(new JButton("Восток"), BorderLayout.EAST);
        panel.add(new JButton("Центр"), BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}
