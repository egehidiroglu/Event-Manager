import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventManagementTest {

    @Test
    public void addConcertEventTest()
    {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addConcertEvent("Aphex Twin", Location.OlympicStadium, LocalDate.now(), 100, 100, "Aphex Twin", new ArrayList<>());

        assertEquals("Aphex Twin", eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1).getName());
        assertEquals(Location.OlympicStadium, eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1).getLocation());
        assertEquals(LocalDate.now(), eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1).getDate());
    }

    @Test
    public void isPresentTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        EventManagement eventManagement = new EventManagement();

        eventManagement.addConcertEvent("Aphex Twin", Location.BellCentre, LocalDate.now(), 100, 100, "Aphex Twin", new ArrayList<>());

        Event event = eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1);

        Method privateMethod = EventManagement.class.getDeclaredMethod("isPresent", Event.class);
        privateMethod.setAccessible(true);

        boolean toCheck = (boolean) privateMethod.invoke(eventManagement, event);
        assertTrue(toCheck);
    }

    @Test
    public void createConcertTest()
    {
        EventManagement eventManagement = new EventManagement();

        Event event1 = eventManagement.createConcert("Aphex Twin", Location.BellCentre, LocalDate.now(), 100, 100, "Aphex Twin", new ArrayList<>());
        Event event2 = eventManagement.createConcert("Burial", Location.BellCentre, LocalDate.now(), 100, 100, "Burial", new ArrayList<>());
        Event event3 = eventManagement.createConcert("Four Tet", Location.PlaceDesArts, LocalDate.of(2021,1,1), 100, 100, "Four Tet", new ArrayList<>());

        assertEquals(event1.hashCode(), event2.hashCode());
        assertNotEquals(event1.hashCode(), event3.hashCode());
    }

    @Test
    public void createGalaEventTest()
    {
        EventManagement eventManagement = new EventManagement();

        Event gala1 = eventManagement.createGala("Gala", Location.PlaceDesArts, LocalDate.now(), 100, 100, new ArrayList<>());
        Event gala2 = eventManagement.createGala("Another Gala", Location.PlaceDesArts, LocalDate.now(), 100, 100, new ArrayList<>());

        assertEquals(gala1.hashCode(), gala2.hashCode());
    }

    @Test
    public void addScreeningEventTest()
    {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addScreeningEvent("Multiverse of Madness", Location.Multiple, LocalDate.now(), 100, 100, Rating.PG13);

        assertEquals("Aphex Twin", eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1).getName());
        assertEquals(LocalDate.now(), eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1).getDate());
    }

    @Test
    public void createScreeningEventTest()
    {
        EventManagement eventManagement = new EventManagement();

        Event screening1 = eventManagement.createScreening("Multiverse of Madness", Location.Multiple, LocalDate.now(), 100, 100, Rating.PG13);
        Event screening2 = eventManagement.createScreening("Obi Wan Kenobi", Location.Multiple, LocalDate.now(), 100, 100, Rating.PG);

        assertEquals(screening1.hashCode(), screening2.hashCode());
    }

    @Test
    public void addFestivalEventTest()
    {
        EventManagement eventManagement = new EventManagement();

        Event event1 = eventManagement.createConcert("Aphex Twin", Location.PlaceDesArts, LocalDate.now(), 100, 100, "Aphex Twin", new ArrayList<>());
        Event event2 = eventManagement.createScreening("Multiverse of Madness", Location.Multiple, LocalDate.now(), 100, 100, Rating.PG13);

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        eventManagement.addFestivalEvent("Random Festival", events);

        assertEquals("Random Festival", eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1).getName());
    }

    @Test
    public void removeEventTest()
    {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addConcertEvent("Aphex Twin", Location.PlaceDesArts, LocalDate.now(), 100, 100, "Aphex Twin", new ArrayList<>());
        eventManagement.addConcertEvent("Burial", Location.BellCentre, LocalDate.of(2002,1,1), 100, 100, "Burial", new ArrayList<>());

        eventManagement.removeEvent(0);

        assertEquals("Burial", eventManagement.getHostedEvents().get(eventManagement.getHostedEvents().size()-1).getName());
    }

    @Test
    public void calculateTotalProfit()
    {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addConcertEvent("Aphex Twin", Location.PlaceDesArts, LocalDate.now(), 100, 100, "Aphex Twin", new ArrayList<>());
        eventManagement.addConcertEvent("Burial", Location.BellCentre, LocalDate.of(2002,1,1), 100, 100, "Burial", new ArrayList<>());

        double expectedProfit = (100*100*0.6) + (100*100*0.6);
        double actualProfit = eventManagement.calculateTotalProfit();

        assertEquals(expectedProfit, actualProfit);
    }



}
