package lab4_1;

import javax.swing.*;
import java.awt.*;

public class LayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Компоновка элементов");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        frame.add(new JLabel("Я метка 1"));
        frame.add(new JLabel("Метка 2"));
        frame.add(new JButton("Кнопка 1"));
        frame.add(new JButton("Кнопка 2"));

        frame.setVisible(true);
    }
}
