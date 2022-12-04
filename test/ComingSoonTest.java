import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ComingSoonTest {

    private ComingSoon comingSoon1;
    private ComingSoon comingSoon2;

    @BeforeEach
    public void setUp()
    {
        comingSoon1 = new ComingSoon("Concert", LocalDate.now(), null, 0, 0);
        comingSoon2 = new ComingSoon("Gala", LocalDate.now());
    }

    @Test
    public void getLocationTest()
    {
        try
        {
            comingSoon1.getLocation();
            comingSoon2.getLocation();
        }
        catch (NullPointerException e)
        {
            fail();
        }
    }

    @Test
    public void getPriceTest()
    {
        try
        {
            comingSoon1.getPrice();
            comingSoon2.getPrice();
        }
        catch (NullPointerException e)
        {
            fail();
        }
    }

    @Test
    public void getNumTicketsTest()
    {
        try
        {
            comingSoon1.getNumTickets();
            comingSoon2.getNumTickets();
        }
        catch (NullPointerException e)
        {
            fail();
        }
    }

    @Test
    public void calculateProfitTest()
    {
        double soon1profit = comingSoon1.calculateProfit();
        double soon2profit = comingSoon2.calculateProfit();

        assertEquals(0, soon1profit);
        assertEquals(0, soon2profit);
    }

}
