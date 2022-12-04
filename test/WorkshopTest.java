import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkshopTest {

    private Workshop workshop;

    @BeforeEach
    public void setUp()
    {
        Workshop prereq1 = new Workshop("Ceramics", Location.PlaceDesArts, LocalDate.now(), 100, 100, new ArrayList<>());
        Workshop prereq2 = new Workshop("Cinema", Location.Multiple, LocalDate.of(2022,1,1), 100, 100, new ArrayList<>());
        List<Workshop> workshops = new ArrayList<>();
        workshops.add(prereq1);
        workshops.add(prereq2);

        workshop = new Workshop("Workshop", Location.PlaceDesArts, LocalDate.now(), 100, 100, workshops);
    }

    @Test
    public void getPrereqsTest()
    {
        Workshop prereq1 = new Workshop("Ceramics", Location.PlaceDesArts, LocalDate.now(), 100, 100, new ArrayList<>());
        Workshop prereq2 = new Workshop("Cinema", Location.Multiple, LocalDate.of(2022,1,1), 100, 100, new ArrayList<>());
        List<Workshop> workshops = new ArrayList<>();
        workshops.add(prereq1);
        workshops.add(prereq2);

        for (int i=0; i<workshop.getPrereqs().size(); i++)
        {
            assertEquals(workshops.get(i).getName(), workshop.getPrereqs().get(i).getName());
        }
    }

    @Test
    public void setPrereqsTest()
    {
        Workshop prereq1 = new Workshop("Football", Location.PlaceDesArts, LocalDate.now(), 100, 100, new ArrayList<>());
        Workshop prereq2 = new Workshop("Basketball", Location.Multiple, LocalDate.of(2022,1,1), 100, 100, new ArrayList<>());
        List<Workshop> workshops = new ArrayList<>();
        workshops.add(prereq1);
        workshops.add(prereq2);

        workshop.setPrereqs(workshops);

        for (int i=0; i<workshop.getPrereqs().size(); i++)
        {
            assertEquals(workshop.getPrereqs().get(i).getName(), workshops.get(i).getName());
        }
    }

    @Test
    public void calculateProfitTest()
    {
        double expected = 100*100*0.5;
        double actual = workshop.calculateProfit();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateVIPTest()
    {
        int expected = 0;
        int actual = workshop.calculateVIP();

        assertEquals(expected, actual);
    }
}
