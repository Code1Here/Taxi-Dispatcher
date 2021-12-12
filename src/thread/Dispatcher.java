package thread;

import java.io.*;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

// Dispatcher processing production of customer requests for taxi service.
public class Dispatcher implements Runnable {
    /**
     * Producer of Producer/Consumer Pattern
     */

    LinkedBlockingQueue<Customer> dispatch;

    public Dispatcher(LinkedBlockingQueue<Customer> dispatch) {
        this.dispatch = dispatch;
    }

    @Override
    public void run() { /** Takes data from .txt to create Customer instance. Fill Queue will Customer objects */
        BufferedReader read = null;
        try
        {
            read = new BufferedReader(new FileReader("CustomerList.txt"));

                while (!Objects.equals(read.readLine(), "no")) {
                    Customer customer = new Customer(read.readLine(),read.readLine(),read.readLine());
                    dispatch.put(customer);
                    Thread.sleep((long)(Math.random() * 7777));
                }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}