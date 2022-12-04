import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Filter;

public class FilterResult {

    private List<Event> aFilteredEvents;

    private FilterResult(List<Event> pEvents)
    {
        assert pEvents!=null;
        aFilteredEvents = Collections.unmodifiableList(pEvents);
    }

    /**
     * @return an unmodifiable list of filtered events.
     */
    public List<Event> getFilteredEvents()
    {
        return Collections.unmodifiableList(aFilteredEvents);
    }

    /**
     *
     * @param rangeStart
     * @param rangeEnd
     * @param pEvents
     * @return Filter Result object with events based on the price range.
     *
     * @pre rangeStart >= 0 && rangeEnd >= 0 && pEvents!=null
     */
    public static FilterResult filterPrice(double rangeStart, double rangeEnd, List<Event> pEvents)
    {
        assert rangeStart >= 0 && rangeEnd >= 0 && pEvents!=null;

        List<Event> filteredEvents = new ArrayList<>();

        for (Event event : pEvents)
        {
            double price = event.getPrice();
            if (price >= rangeStart && price <= rangeEnd)
            {
                filteredEvents.add(event);
            }
        }

        return new FilterResult(filteredEvents);
    }

    /**
     * @param pLocation
     * @param pEvents
     * @return Filter Result object with events based on location.
     *
     * @pre pLocation!=null && pEvents!=null
     */
    public static FilterResult filterLocation(Location pLocation, List<Event> pEvents)
    {
        assert pLocation!=null && pEvents!=null;

        List<Event> filteredEvents = new ArrayList<>();

        for (Event event : pEvents)
        {
            if (event.getLocation() == pLocation)
            {
                filteredEvents.add(event);
            }
        }

        return new FilterResult(filteredEvents);

    }

    /**
     * @param rangeStart
     * @param rangeEnd
     * @param pLocation
     * @param pEvents
     * @return Filter Result object based on both the price range and the location
     *
     * @pre rangeStart >= 0 && rangeEnd >= 0 && pLocation != null && pEvents!=null;
     */
    public static FilterResult priceAndLocationFilter(double rangeStart, double rangeEnd, Location pLocation, List<Event> pEvents)
    {
        assert rangeStart >= 0 && rangeEnd >= 0 && pLocation!=null && pEvents!=null;

        List<Event> priceFiltered = filterPrice(rangeStart, rangeEnd, pEvents).getFilteredEvents();
        List<Event> priceAndLocationFiltered = filterLocation(pLocation, priceFiltered).getFilteredEvents();

        return new FilterResult(priceAndLocationFiltered);
    }

    /**
     *
     * @return The expected profit of the filtered events based on profit percentage of each event
     */
    public double calculateExpectedProfit()
    {
        int profitSum = 0;

        for (Event event : aFilteredEvents)
        {
            profitSum += event.calculateProfit();
        }

        return profitSum;
    }

    /**
     * @return the total number of VIPs across all events
     */
    public int calculateNumOfVips()
    {
        int total = 0;

        for (Event event : aFilteredEvents)
        {
            total += event.calculateVIP();
        }

        return total;
    }
}
