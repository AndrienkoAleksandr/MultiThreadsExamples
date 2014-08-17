package interruptedandjoin.interrupt;

/**
 * Created by USER on 11.08.2014.
 */
public class MyRunnable1 implements Runnable{
    private Thread thread;
    public static boolean sleepNow = false;
    public MyRunnable1() {
        thread = new Thread(this, "MyRunnable1");
    }

    @Override
    public void run() {
//        while (true) { //interrupt can't stop endless cycle
            for (int i = 0; i <= 100000000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                if (i % 10000 == 0) {
                    System.out.println(i);
                }
                if (sleepNow) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
//        }
    }
}
