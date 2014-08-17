/**
 * This class display how to use interface Callable with ExecutorService
 */
import java.util.*;
import java.util.concurrent.*;

public class CallableExample1 {

    public static class WordLengthCallable implements Callable {
        private String word;
        public static int count = 0;
        private final int numberOfThread = count++;

        public WordLengthCallable(String word) {
            this.word = word;
        }

        public Integer call() {
            int sum = 0;
            for (int i = 0; i < 100000; i++) {
                sum += i;
            }
            System.out.println(numberOfThread);
            return Integer.parseInt(word);
        }
    }

    public static void main(String args[]) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();
        String[] args1 = "13 12 12 14".split(" ");
        for (String word: args1) {
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.printf("The sum of lengths is %s%n", sum);
        System.exit(sum);
    }
}
