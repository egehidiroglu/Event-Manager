import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FestivalTest {

    private Festival festival;

    @BeforeEach
    public void setUp()
    {
        List<String> concertVIPs = new ArrayList<>();
        concertVIPs.add("James");
        concertVIPs.add("John");

        Event concert = new Concert("Aphex Twin", Location.BellCentre, LocalDate.now(), 100, 100, "Aphex Twin", concertVIPs);
        Event screening = new Screening("Multiverse of Madness", Location.Multiple, LocalDate.of(2023,1,1), 100, 100, Rating.PG13);
        Event workshop = new Workshop("Ceramics", Location.PlaceDesArts, LocalDate.of(2024,1,1), 100, 100, new ArrayList<>());

        List<Event> events = new ArrayList<>();
        events.add(concert);
        events.add(screening);
        events.add(workshop);

        festival = new Festival("Random Festival", events);
    }

    @Test
    public void calculateLocationTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = Festival.class.getDeclaredMethod("calculateLocation");
        privateMethod.setAccessible(true);

        Location toCheck = (Location) privateMethod.invoke(festival);

        assertEquals(Location.Multiple, toCheck);
    }

    @Test
    public void calculateDateTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = Festival.class.getDeclaredMethod("calculateDate");
        privateMethod.setAccessible(true);

        LocalDate toCheck = (LocalDate) privateMethod.invoke(festival);

        assertEquals(toCheck, LocalDate.now());
    }

    @Test
    public void calculatePriceTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Festival.class.getDeclaredMethod("calculatePrice");
        method.setAccessible(true);

        double actual = (double) method.invoke(festival);
        double expected = (100+100+100)*0.2;

        assertEquals(actual, expected);
    }

    @Test
    public void calculateTicketsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Festival.class.getDeclaredMethod("calculateTickets");
        method.setAccessible(true);

        int actual = (int) method.invoke(festival);
        int expected = 100;

        assertEquals(expected, actual);
    }

    @Test
    public void calculateProfitTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Festival.class.getDeclaredMethod("calculateProfit");
        method.setAccessible(true);

        double actual = (double) method.invoke(festival);
        double expected = (100*100*0.6) + (100*100*0.1) + (100*100*0.5);

        assertEquals(actual, expected);
    }

    @Test
    public void calculateVIPTest()
    {
        int actual = festival.calculateVIP();
        int expected = 2;

        assertEquals(expected, actual);
    }

}
