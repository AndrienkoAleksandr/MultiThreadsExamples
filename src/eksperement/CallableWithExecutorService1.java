package eksperement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 */
public class CallableWithExecutorService1 {
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
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<WordLengthCallable> listThreads = new ArrayList<WordLengthCallable>(
                Arrays.asList(
                        new WordLengthCallable(), new WordLengthCallable(),
                        new WordLengthCallable(), new WordLengthCallable())
        );
        CompletionService<Integer> completionService = new ExecutorCompletionService(service);
        for (WordLengthCallable elem: listThreads) {
            if (elem instanceof Callable) {
                completionService.submit(elem);
            }
        }
        for (int i = 0; i < 4; i++) {
            try {
                int result = completionService.take().get().intValue();
                System.out.println("result is " + result);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
