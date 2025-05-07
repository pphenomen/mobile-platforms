import java.util.concurrent.BlockingQueue;

class DeliveryWorker implements Runnable {
    private final BlockingQueue<Clothes> conveyor;

    public DeliveryWorker(BlockingQueue<Clothes> conveyor) {
        this.conveyor = conveyor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Clothes c = conveyor.take();
                System.out.println("Работница начала выдачу: " + c);
                Thread.sleep(1000); // выдача
                System.out.println("Работница выдала заказ: " + c);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}