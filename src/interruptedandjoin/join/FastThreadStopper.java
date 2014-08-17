package interruptedandjoin.join;

/**
 * Created by USER on 11.08.2014.
 */
public class FastThreadStopper implements Runnable{
    Thread thisThread;
    Thread foreignThread;
    public FastThreadStopper(Thread foreignThread) {
        this.foreignThread = foreignThread;
        this.thisThread = new Thread(this);
    }

    public Thread getInstance() {
        return thisThread;
    }

    @Override
    public void run() {
        try {
            System.out.println("I'm too fast for my partner. I'm waiting for him");
            foreignThread.join();
            for(long i = 0; i < 200; i++);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Fast thread completed");
    }
}
