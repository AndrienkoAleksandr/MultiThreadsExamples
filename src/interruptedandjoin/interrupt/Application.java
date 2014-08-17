package interruptedandjoin.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 11.08.2014.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable1());
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyRunnable1.sleepNow = true;//comment it if you won't see exception
        thread.interrupt();
        thread.join();
        if (thread.getState() == Thread.State.TERMINATED) {
            System.out.println("Thread exception " +thread.getState());
        }
        System.out.println(thread.isAlive());
    }
}
