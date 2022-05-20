package threadforloop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTwo {
    public static void main(String[] args) {
        // Batch of 10 thread will run at a given point of time. Rest will be in the waiting state.
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0; i<100; i++)
        {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.submit(numberPrinter);

            if(i == 30)
            {
                System.out.println("wait");
            }
        }
    }
}
