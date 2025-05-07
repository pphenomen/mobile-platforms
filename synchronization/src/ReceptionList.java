import java.util.Queue;
import java.util.concurrent.BlockingQueue;

class Receptionist implements Runnable {
    private final BlockingQueue<Clothes> conveyor;
    private final Queue<Clothes> taskQueue;
    private final int id;

    public Receptionist(int id, BlockingQueue<Clothes> conveyor, Queue<Clothes> taskQueue) {
        this.id = id;
        this.conveyor = conveyor;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!taskQueue.isEmpty()) {
            Clothes c;
            synchronized (taskQueue) {
                c = taskQueue.poll();
            }
            if (c != null) {
                System.out.println("Приёмщица " + id + " приняла: " + c);
                try {
                    Thread.sleep(500); // обработка
                    conveyor.put(c);   // отправка на конвейер
                    System.out.println("Приёмщица " + id + " отправила в чистку: " + c);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
