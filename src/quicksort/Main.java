package quicksort;


import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(21, 31, 19, 23, 54).
                collect(Collectors.toList());

        QuickSort quickSort = new QuickSort(list);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> sortedList = executorService.submit(quickSort);

        List<Integer> sorted;

        {
            try {
                sorted = sortedList.get();
                System.out.println(sorted);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
