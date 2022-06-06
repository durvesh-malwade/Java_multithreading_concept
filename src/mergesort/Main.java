package mergesort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(21, 31, 19, 23, 54)
                .collect(Collectors.toList()); // In java 9 onwards you can use List.of() directly instead of the entire Stream code.

        MergeSort mergeSort = new MergeSort(list);

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<List<Integer>> sortedList = executorService.submit(mergeSort);
        try {
            List<Integer> sorted = sortedList.get();
            System.out.println(sorted);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (Exception e)
        {
            System.out.printf("Exection in class");
        }
    }
}
