package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MainDispatcher {

    public static LinkedBlockingQueue<Customer> dispatch = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {

        // The customer is the 'Producer' of this pattern, producing requests
        ExecutorService producerExecutor = Executors.newFixedThreadPool(1);
        producerExecutor.execute(new Dispatcher(dispatch));

        // The driver is the 'consumer' of the work demanded of them
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Driver(dispatch, (byte) 1));
        executor.execute(new Driver(dispatch, (byte) 2));
        executor.execute(new Driver(dispatch, (byte) 3));
        executor.execute(new Driver(dispatch, (byte) 4));
        executor.execute(new Driver(dispatch, (byte) 5));

        executor.shutdown();
        producerExecutor.shutdown();
    }
}

/** Summary of what to do
 ****************
 5 Drivers. Drivers will TAKE

 Driver max is 4 before termination

 Pull Customer info from .txt w/ delimiter

 Customer object provided

 queue into obj loads <-Dispatcher-> reads .txt

 // What goes into the Driver OBJ?
 // Contructor with a statement and static var
 */