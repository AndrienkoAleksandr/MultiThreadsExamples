package eksperement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by USER on 11.08.2014.
 */
public class CallableWithoutExecutorService2 {

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
        List<FutureTask<Integer>> list = new ArrayList<FutureTask<Integer>>(
                Arrays.asList(new FutureTask<Integer>(new WordLengthCallable()),
                new FutureTask<Integer>(new WordLengthCallable()),
                new FutureTask<Integer>(new WordLengthCallable()),
                new FutureTask<Integer>(new WordLengthCallable()))
        );
        for (FutureTask<Integer> elem: list) {
            new Thread(elem).start();
        }
        int sum = 0;
        for (FutureTask<Integer> elem: list) {
            try {
                sum += elem.get().intValue();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Result = " + sum);
        System.exit(0);
    }
}
