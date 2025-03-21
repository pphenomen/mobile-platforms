package lab4_1;

import javax.swing.*;
import java.awt.*;

public class LabelsAndButtons {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Компоновка элементов");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        // panel.setLayout(new GridLayout(4,5));

        for (int i = 1; i <= 5; i++) {
            panel.add(new JLabel("Метка " + i));
        }

        for (int i = 1; i <= 4; i++) {
            panel.add(new JButton("Кнопка " + i));
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}
