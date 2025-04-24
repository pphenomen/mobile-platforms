package RaceApp;

import javax.swing.*;
import java.util.Random;

public class RacerThread implements Runnable {
    private final String name;
    private final JProgressBar bar;
    private final RaceMonitor monitor;
    private final Random rand = new Random();

    public RacerThread(String name, JProgressBar bar, RaceMonitor monitor) {
        this.name = name;
        this.bar = bar;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        int progress = 0;
        while (progress < 100) {
            try {
                int step = rand.nextInt(10) + 1;
                progress = Math.min(progress + step, 100);

                int finalProgress = progress;
                SwingUtilities.invokeLater(() -> bar.setValue(finalProgress));

                Thread.sleep(200 + rand.nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        monitor.finished(name);
    }
}
