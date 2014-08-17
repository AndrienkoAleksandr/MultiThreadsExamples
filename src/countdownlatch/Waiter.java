package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by USER on 11.08.2014.
 */
public class Waiter implements Runnable {
    CountDownLatch countDownLatch;

    public Waiter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter ");
    }
}
