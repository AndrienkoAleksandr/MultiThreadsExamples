package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by USER on 11.08.2014.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Counter counter = new Counter(countDownLatch);
        Waiter waiter = new Waiter(countDownLatch);
        new Thread(counter).start();
        new Thread(waiter).start();
        Thread.sleep(5000);
    }
}
