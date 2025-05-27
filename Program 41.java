import java.util.concurrent.*;
import java.util.*;

public class ExecutorCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            return "Result of Task 1";
        };

        Callable<String> task2 = () -> "Result of Task 2";

        List<Callable<String>> tasks = Arrays.asList(task1, task2);

        List<Future<String>> results = executor.invokeAll(tasks);

        for (Future<String> future : results) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
}
