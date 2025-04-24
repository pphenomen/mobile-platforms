package RaceApp;

import javax.swing.*;

public class RaceMonitor {
    private final int total;
    private int finished = 0;
    private final String[] places;
    private final JLabel labelToUpdate;

    public RaceMonitor(int total, JLabel labelToUpdate) {
        this.total = total;
        this.places = new String[total];
        this.labelToUpdate = labelToUpdate;
    }

    public synchronized void finished(String name) {
        places[finished] = name;
        finished++;

        if (finished == total) {
            SwingUtilities.invokeLater(() -> {
                String result = "Первым прибыл: " + places[0] + ", последним — " + places[total - 1];
                labelToUpdate.setText(result);
                JOptionPane.showMessageDialog(null, result, "Результаты гонки", JOptionPane.INFORMATION_MESSAGE);
            });
        }
    }
}
