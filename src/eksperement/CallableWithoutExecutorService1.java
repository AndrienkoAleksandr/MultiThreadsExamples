package eksperement;

import java.util.concurrent.Callable;

/**
 *
 */
public class CallableWithoutExecutorService1 {
    public static class WordLengthCallable implements Callable {
    public static int count = 0;
    private final int numberOfThread = count++;

    public Integer call() throws InterruptedException {
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        System.out.println(numberOfThread);
        return numberOfThread;
    }
}
    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                new WordLengthCallable().call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
