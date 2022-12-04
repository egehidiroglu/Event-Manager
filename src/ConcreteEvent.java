import java.time.LocalDate;
import java.util.Optional;

public abstract class ConcreteEvent implements Event{

    private final String aName;
    private final Location aLocation;
    private final LocalDate aDate;
    private final double aPrice;
    private final int aNumTickets;

    public ConcreteEvent(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets)
    {
        assert pName!=null && pLocation!=null && pDate!=null && pPrice>=0 && pNumTickets>=0;
        this.aName = pName;
        this.aLocation = pLocation;
        this.aDate = pDate;
        this.aPrice = pPrice;
        this.aNumTickets = pNumTickets;
    }

    /**
     * @return the name of the event
     */
    @Override
    public String getName()
    {
        return this.aName;
    }

    /**
     * @return the location of the event.
     */
    @Override
    public Location getLocation()
    {
        return this.aLocation;
    }

    /**
     * @return the date of the event.
     */
    @Override
    public LocalDate getDate()
    {
        return this.aDate;
    }

    /**
     * @return the price of the event
     */
    @Override
    public double getPrice()
    {
        return this.aPrice;
    }

    /**
     * @return the number of tickets
     */
    @Override
    public int getNumTickets()
    {
        return this.aNumTickets;
    }

}
