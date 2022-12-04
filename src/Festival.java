import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Festival implements Event, Profit, Vip{

    private final String aName;
    private final Location aLocation;
    private final LocalDate aDate;
    private final double aPrice;
    private final int aNumTickets;
    private final List<Event> aEvents;

    public Festival(String pName, List<Event> pEvents) {
        assert pName!=null && pEvents!=null;
        this.aName = pName;
        this.aEvents = pEvents;
        this.aLocation = calculateLocation();
        this.aDate = calculateDate();
        this.aPrice = calculatePrice();
        this.aNumTickets = calculateTickets();
    }

    /**
     *
     * @return An unmodifiable list of the events in festival.
     */
    public List<Event> getEvents()
    {
        return Collections.unmodifiableList(aEvents);
    }

    /**
     * @return the name of the festival
     */
    @Override
    public String getName() {
        return this.aName;
    }

    /**
     * @return the location of the festival
     */
    @Override
    public Location getLocation() {
        return this.aLocation;
    }

    /**
     * @return the calculated location of the festival based on locations of each event.
     */
    private Location calculateLocation()
    {
        boolean same = true;
        for (int i = 0; i < aEvents.size(); i++)
        {
            for (int j = 0; j < aEvents.size(); j++)
            {
                if (aEvents.get(i).getLocation()!=aEvents.get(j).getLocation())
                {
                    same = false;
                }
            }
        }

        if (same)
        {
            return aEvents.get(0).getLocation();
        }

        else
        {
            return Location.Multiple;
        }

    }

    /**
     * @return the date of the festival
     */
    @Override
    public LocalDate getDate() {
        return this.aDate;
    }

    /**
     * @return the date of the festival based on earliest starting event.
     */
    private LocalDate calculateDate()
    {
        LocalDate first = aEvents.get(0).getDate();
        for (Event event : aEvents)
        {
            if (event.getDate().isBefore(first))
            {
                first = event.getDate();
            }
        }
        return first;
    }

    /**
     * @return the price of the festival.
     */
    @Override
    public double getPrice() {
        return this.aPrice;
    }

    /**
     * @return the price of the festival based on the prices of each event.
     */
    private double calculatePrice()
    {
        double sum = 0;
        for (Event event : aEvents)
        {
            sum += event.getPrice();
        }
        return sum * 0.2;
    }

    /**
     * @return the number of tickets for the festival
     */
    @Override
    public int getNumTickets() {
        return this.aNumTickets;
    }

    /**
     * @return the numeber of tickets based on event with minimum number of tickets.
     */
    private int calculateTickets()
    {
        int min = Integer.MAX_VALUE;
        for (Event event : aEvents)
        {
            if (event.getNumTickets() < min)
            {
                min = event.getNumTickets();
            }
        }
        return min;
    }

    /**
     * @return the expected profit of the festival based on the profits of each event.
     */
    public double calculateProfit()
    {
        double profit = 0;

        for (Event event : aEvents)
        {
            profit += event.calculateProfit();
        }

        return profit;
    }

    public int calculateVIP()
    {
        int vips = 0;

        for (Event event : aEvents)
        {
            vips += event.calculateVIP();
        }

        return vips;
    }

}
