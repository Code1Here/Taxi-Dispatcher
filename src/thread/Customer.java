package thread;

public class Customer{

    private String name;//name of customer
    private String destination;//destination  point for drop-off
    private String pickUpPoint;//pickup Point for limo


    public Customer(String name, String destination, String pickUpPoint)//constructor
    {
        this.name        = name;
        this.destination = destination;
        this.pickUpPoint = pickUpPoint;
    }

    public String getName(){ return name; }
    public String getDestination(){ return destination; }
    public String getPickUpPoint(){ return pickUpPoint; }

}