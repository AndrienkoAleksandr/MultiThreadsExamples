package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by USER on 11.08.2014.
 */
public class Counter implements Runnable{
    CountDownLatch countDownLatch;
    public Counter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter One");
        countDownLatch.countDown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter Two");
        countDownLatch.countDown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter Three");
        countDownLatch.countDown();
    }
}
