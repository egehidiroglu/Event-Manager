import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Filter;

public class Driver {

    public static void main(String[] args) {

        // Event Management with no events on the same date and location. Profit calculation. Remove event. Filter Result.
        EventManagement events = new EventManagement();
        events.addConcertEvent("Aphex Twin", Location.OlympicStadium, LocalDate.of(2022,1,1), 100, 150, "Aphex Twin", new ArrayList<>());
        events.addGalaEvent("Gala", Location.Multiple, LocalDate.of(2022,2,2), 100, 150, new ArrayList<>());
        events.addScreeningEvent("Multiverse of Madness", Location.Multiple, LocalDate.of(2022,3,3), 100, 150, Rating.PG13);
        events.addWorkshopEvent("Workshop", Location.BellCentre, LocalDate.of(2022,4,4), 100, 150, new ArrayList<>());

        List<String> VIPs = new ArrayList<>();
        VIPs.add("Thom Yorke");
        VIPs.add("Richard D. James");
        VIPs.add("William E. Bevan");

        events.addConcertEvent("Boards of Canada", Location.PlaceDesArts, LocalDate.of(2022,5,5), 50, 150, "BoC", VIPs);

        Event concert = events.createConcert("Sufjan Stevens", Location.BellCentre, LocalDate.of(2021,1,1), 50, 100, "Sufjan Stevens", new ArrayList<>());
        Event screening = events.createScreening("Sonic", Location.Multiple, LocalDate.of(2021,2,2), 18, 100, Rating.G);

        // Creating a festival event
        List<Event> festivalEvents = new ArrayList<>();
        festivalEvents.add(concert);
        festivalEvents.add(screening);

        events.addFestivalEvent("Random Festival", festivalEvents);

        // Removing Gala Event
        events.removeEvent(1);

        for (Event event : events.getHostedEvents())
        {
            System.out.println("Name: " + event.getName()
            +"\nHashCode: " + event.hashCode()
            + "\nClass: " + event.getClass());

            System.out.println();
        }

        events.profitReport();

        FilterResult filteredLocation = FilterResult.filterLocation(Location.Multiple, events.getHostedEvents());
        FilterResult filteredPrice = FilterResult.filterPrice(25, 75, events.getHostedEvents());
        FilterResult filterLocAndPrice = FilterResult.priceAndLocationFilter(75, 125, Location.BellCentre, events.getHostedEvents());

        System.out.println("Displaying the result for filter based on Multiple Locations");
        for (Event event : filteredLocation.getFilteredEvents())
        {
            System.out.println("Name: " + event.getName()
            + "\nLocation: " + event.getLocation());
        }

        System.out.println("Displaying the result for filter based on Price Range - 25 to 75");
        for (Event event : filteredPrice.getFilteredEvents())
        {
            System.out.println("Name: " + event.getName()
            + "\nPrice: " + event.getPrice());
        }

        System.out.println("Displaying the result for filter based on Price Range and Location - 75 to 125 and Bell Centre");
        for (Event event : filterLocAndPrice.getFilteredEvents())
        {
            System.out.println("Name: " + event.getName()
            + "\nLocation: " + event.getLocation()
            + "\nPrice: " + event.getPrice());
        }

        System.out.println("VIPs: " + filteredPrice.calculateNumOfVips());

        System.out.println();
        System.out.println("==========================================================================");
        System.out.println();

        // Event Management with colliding date and locations. Coming Soon event with no date provided. Profit Calculation with Coming Soon event included.
        EventManagement eventManagement = new EventManagement();
        eventManagement.addConcertEvent("Black Midi", Location.BellCentre, LocalDate.of(2020,1,1), 100, 150, "Black Midi",new ArrayList<>());
        // This event won't be added to the aHostedEvents list because it has the same hashcode as the event before
        eventManagement.addConcertEvent("Four Tet", Location.BellCentre, LocalDate.of(2020,1,1), 100, 150, "Four Tet", new ArrayList<>());
        eventManagement.addComingSoonEvent("Fantastic Four", Location.Multiple, null, 0, 0);

        for (Event event : eventManagement.getHostedEvents())
        {
            System.out.println("Name: " + event.getName()
            + "\nHashcode: " + event.hashCode()
            + "\nLocation: " + event.getDate());
        }

        eventManagement.profitReport();

        ComingSoon soon = new ComingSoon("james", LocalDate.now());
        soon.getLocation();





    }


}
