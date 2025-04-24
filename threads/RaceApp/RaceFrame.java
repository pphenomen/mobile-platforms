package RaceApp;

import javax.swing.*;
import java.awt.*;

public class RaceFrame extends JFrame {
    private final JProgressBar[] bars = new JProgressBar[3];
    private final JLabel resultLabel = new JLabel("Ожидание результатов гонки...");
    private final RaceMonitor monitor = new RaceMonitor(3, resultLabel);

    public RaceFrame() {
        setTitle("Гонки с ProgressBar");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel("Участник " + (i + 1));
            bars[i] = new JProgressBar(0, 100);
            bars[i].setStringPainted(true);
            add(label);
            add(bars[i]);
        }

        add(resultLabel);
        setVisible(true);
    }

    public void startRace() {
        for (int i = 0; i < 3; i++) {
            new Thread(new RacerThread("Участник " + (i + 1), bars[i], monitor)).start();
        }
    }
}
