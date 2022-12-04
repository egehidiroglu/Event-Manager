import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScreeningTest {

    private Screening screening;

    @BeforeEach
    public void setUp()
    {
        screening = new Screening("Multiverse of Madness", Location.Multiple, LocalDate.of(2022,5,5), 100, 100, Rating.PG13);
    }

    @Test
    public void getRatingTest()
    {
        assertEquals(Rating.PG13, screening.getRating());
    }

    @Test
    public void setRatingTest()
    {
        screening.setRating(Rating.R);
        assertEquals(Rating.R, screening.getRating());
    }

    @Test
    public void calculateProfitTest()
    {
        double expected = 100*100*0.1;
        double actual = screening.calculateProfit();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateVIPTest()
    {
        int expected = 0;
        int actual = screening.calculateVIP();

        assertEquals(expected, actual);
    }
}
