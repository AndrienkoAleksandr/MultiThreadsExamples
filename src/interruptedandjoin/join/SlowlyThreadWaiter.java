package interruptedandjoin.join;

/**
 * Created by USER on 11.08.2014.
 */
public class SlowlyThreadWaiter implements Runnable {
    Thread thisTread;
    public SlowlyThreadWaiter() {
        thisTread = new Thread(this);
    }

    public Thread getInstance() {
        return thisTread;
    }

    @Override
    public void run() {
            for(long i = 0; i < 2000000000; i++);
        System.out.println("Slowly thread completed");
    }
}
