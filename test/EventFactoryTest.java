import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EventFactoryTest {

    @Test
    public void createConcertTest()
    {
        Event concert1 = EventFactory.createConcert("Aphex Twin", Location.BellCentre, LocalDate.now(), 100, 100, "Aphex Twin",new ArrayList<>());
        Event concert2 = EventFactory.createConcert("Burial", Location.BellCentre, LocalDate.now(), 100, 100, "Burial", new ArrayList<>());

        assertEquals(concert1.hashCode(), concert2.hashCode());
    }

    @Test
    public void createWorkshopTest()
    {
        // 2 workshops with same date and location
        Event workshop1 = EventFactory.createWorkshop("Ceramics", Location.BellCentre, LocalDate.now(), 100, 100, new ArrayList<>());
        Event workshop2 = EventFactory.createWorkshop("Cooking", Location.BellCentre, LocalDate.now(), 100, 100, new ArrayList<>());
        // 1 workshop with same date but different location
        Event workshop3 = EventFactory.createWorkshop("Cinema", Location.Multiple, LocalDate.of(2021,1,1), 100, 100, new ArrayList<>());

        assertEquals(workshop1.hashCode(), workshop2.hashCode());
        assertNotEquals(workshop3.hashCode(), workshop1.hashCode());
        assertNotEquals(workshop3.hashCode(), workshop2.hashCode());

    }

    @Test
    public void createGalaTest()
    {
        Event gala1 = EventFactory.createGala("Gala", Location.Multiple, LocalDate.now(), 100, 100, new ArrayList<>());
        Event gala2 = EventFactory.createGala("Gala", Location.BellCentre, LocalDate.of(2021,1,1), 100, 100, new ArrayList<>());
        Event concert = EventFactory.createConcert("Concert", Location.Multiple, LocalDate.now(), 100, 100, "Aphex Twin", new ArrayList<>());


        assertEquals(gala1.hashCode(), concert.hashCode());
        assertNotEquals(gala2.hashCode(), gala1.hashCode());
    }

    @Test
    public void createScreeningTest()
    {
        Event screening1 = EventFactory.createScreening("Multiverse of Madness", Location.Multiple, LocalDate.of(2022, 5, 5), 100, 100, Rating.PG13);
        Event screening2 = EventFactory.createScreening("Obi-Wan Kenobi", Location.Multiple, LocalDate.of(2022,5,5), 100, 100, Rating.PG);

        assertEquals(screening1.hashCode(), screening2.hashCode());
    }
}
