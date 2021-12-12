package thread;

import java.util.concurrent.*;

// A task for reading and deleting a request from the queue as service is provided
public class Driver implements Runnable {
    /**
     * Consumer of Producer/Consumer Pattern
     */

    LinkedBlockingQueue<Customer> dispatch;

    private byte driverNo;
    private byte customerCount;
    private final byte customerCountLimit = 4;

    public Driver(LinkedBlockingQueue<Customer> dispatch, byte driverNo) {
        this.dispatch = dispatch;
        customerCount = 0;
        this.driverNo = driverNo;
        System.out.println(driverNo + " is on duty.\n");
    }

    public void run() {
        try {
            while (customerCount != customerCountLimit) {
                Customer customer = dispatch.take();
                ++customerCount;
                System.out.println(customer.getName() + " has been picked up by diver #" + driverNo +
                        " proceeding from " + customer.getPickUpPoint() + " to " + customer.getDestination() +
                        " (The customer count is " + customerCount + ")\n");

                Thread.sleep((long)(Math.random() * 7777));

                System.out.println(customer.getName() + " was dropped off at " + customer.getDestination() +
                        " by driver #" + driverNo + "\n");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if (customerCount == customerCountLimit)
            System.out.println(driverNo + " is off duty. 4 customers were picked up today\n");
    }
}
