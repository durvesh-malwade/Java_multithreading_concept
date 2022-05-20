package threadforloop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> allThreads = new ArrayList<>();

        // Create object of a class that implements Runnable
        // Create an object of Thread and pass the oobj of runnable to constructor
        // start the thread
        for(int i=0; i<100; i++)
        {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread t = new Thread(numberPrinter);
            allThreads.add(t);
            t.start();
        }

        // In this we get the numbers output in random manner and not in the sequence as for every number
        // a new thread i screated and the execution of them takes place parallely hence the output
        // is in varied format
        
        for(int i=0; i<100; i++)
        {
            allThreads.get(i).join();
        }

        // If you want to run a particular class within a thread
        // Make that class implement Runnable
        // override the run method of the class()


    }
}
