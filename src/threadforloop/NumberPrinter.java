package threadforloop;

public class NumberPrinter implements Runnable{
    // The class implements Runnable
    // we have also Override the run method()

    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("The number is" + number);
    }
}
