import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Clothes> conveyor = new LinkedBlockingQueue<>();
        Queue<Clothes> taskQueue = new ConcurrentLinkedQueue<>();

        // Симулируем клиентов
        for (int i = 1; i <= 10; i++) {
            taskQueue.add(new Clothes(i, "Одежда#" + i));
        }

        // Запуск приёмщиц
        Thread r1 = new Thread(new Receptionist(1, conveyor, taskQueue));
        Thread r2 = new Thread(new Receptionist(2, conveyor, taskQueue));
        Thread r3 = new Thread(new Receptionist(3, conveyor, taskQueue));

        // Запуск работницы по выдаче
        Thread delivery = new Thread(new DeliveryWorker(conveyor));

        r1.start();
        r2.start();
        r3.start();
        delivery.start();

        r1.join();
        r2.join();
        r3.join();

        // После завершения всех приёмщиц ждём очистку очереди и прерываем работницу
        Thread.sleep(5000);
        delivery.interrupt();
    }
}
