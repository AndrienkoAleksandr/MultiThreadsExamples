package interruptedandjoin.join;

/**
 * Created by USER on 12.08.2014.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        SlowlyThreadWaiter threadStopper = new SlowlyThreadWaiter();
        FastThreadStopper fastThreadStopper = new FastThreadStopper(threadStopper.getInstance());
        threadStopper.getInstance().start();
        fastThreadStopper.getInstance().start();
        Thread.sleep(5000);
    }
}
