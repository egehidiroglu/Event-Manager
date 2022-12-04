import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilterResultTest {

    private List<Event> events;

    @BeforeEach
    public void setUp()
    {
        List<String> VIPs = new ArrayList<>();
        VIPs.add("John");
        VIPs.add("Hal");

        Event concert = new Concert("Aphex Twin", Location.PlaceDesArts, LocalDate.now(), 50, 100, "Aphex Twin", VIPs);
        Event screening = new Screening("Multiverse of Madness", Location.Multiple, LocalDate.now(), 75, 100, Rating.PG13);
        Event gala = new Gala("Gala", Location.BellCentre, LocalDate.now(), 100, 100, new ArrayList<>());
        Event workshop = new Workshop("Workshop", Location.Multiple, LocalDate.now(), 100, 100, new ArrayList<>());

        events = new ArrayList<>();

        events.add(concert);
        events.add(screening);
        events.add(gala);
        events.add(workshop);
    }

    @Test
    public void filterPriceTest()
    {
        FilterResult filterPrice = FilterResult.filterPrice(40, 60, events);

        assertEquals("Aphex Twin", filterPrice.getFilteredEvents().get(0).getName());
    }

    @Test
    public void filterLocationTest()
    {
        FilterResult filterLocation = FilterResult.filterLocation(Location.Multiple, events);

        for (int i=0; i<filterLocation.getFilteredEvents().size(); i++)
        {
            assertEquals(Location.Multiple, filterLocation.getFilteredEvents().get(i).getLocation());
        }
    }

    @Test
    public void priceAndLocationFilterTest()
    {
        FilterResult priceAndLocation = FilterResult.priceAndLocationFilter(75, 100, Location.Multiple, events);

        for (int i=0; i<priceAndLocation.getFilteredEvents().size(); i++)
        {
            assertEquals(Location.Multiple, priceAndLocation.getFilteredEvents().get(i).getLocation());
            assert priceAndLocation.getFilteredEvents().get(i).getPrice() >= 75 && priceAndLocation.getFilteredEvents().get(i).getPrice() <= 100;
        }
    }

    @Test
    public void calculateExpectedProfitTest()
    {
        FilterResult filterLocation = FilterResult.filterLocation(Location.PlaceDesArts, events);

        double actual = filterLocation.calculateExpectedProfit();
        double expected = (50*100*0.6);

        assertEquals(actual, expected);
    }

    @Test
    public void calculateNumOfVips()
    {
        FilterResult filterResult = FilterResult.priceAndLocationFilter(25, 150, Location.PlaceDesArts, events);

        int actual = filterResult.calculateNumOfVips();
        int expected = 2;

        assertEquals(expected, actual);
    }
}
