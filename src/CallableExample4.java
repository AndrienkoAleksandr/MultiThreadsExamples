import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by USER on 10.08.2014.
 */
public class CallableExample4 {

    public static int count = 0;

    public static class WordLengthCallable implements Callable{
        private String word;
        public WordLengthCallable(String word) {
            this.word = word;
        }
        private final int numberOfThread = count++;
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
        String[] args1 = "13 12 12 14".split(" ");
        List<FutureTask<Integer>> listFuture = new ArrayList<FutureTask<Integer>>(
            Arrays.asList(new FutureTask<Integer>(new WordLengthCallable(args1[0])),
                    new FutureTask<Integer>(new WordLengthCallable(args1[1])),
                    new FutureTask<Integer>(new WordLengthCallable(args1[2])),
                    new FutureTask<Integer>(new WordLengthCallable(args1[3])))
        );
        int sum = 0;
        for (FutureTask<Integer> future : listFuture) {
            new Thread(future).start();
        }
        for (FutureTask<Integer> future : listFuture) {
            future.get().intValue();
        }
        System.out.printf("The sum of lengths is %s%n", sum);
        System.exit(sum);
    }
}
