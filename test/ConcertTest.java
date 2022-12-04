import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConcertTest {

    private Concert concert;

    @BeforeEach
    public void setUp()
    {
        List<String> VIPs = new ArrayList<>();
        VIPs.add("William E. Bevan");
        VIPs.add("Thom Yorke");
        concert = new Concert("Aphex Twin", Location.BellCentre, LocalDate.now(), 100, 100, "Aphex Twin", VIPs);
    }

    @Test
    public void getArtistTest()
    {
        assertEquals("Aphex Twin", concert.getArtist());
    }

    @Test
    public void setArtistTest()
    {
        concert.setArtist("James");
        assertEquals("James", concert.getArtist());
    }

    @Test
    public void getVIPsTest()
    {
        List<String> VIPs = concert.getVIPs();
        assertEquals(VIPs, concert.getVIPs());
    }

    @Test
    public void setVIPsTest()
    {
        List<String> VIPs = new ArrayList<>();
        VIPs.add("James");
        VIPs.add("Tim");
        concert.setVIPs(VIPs);
        assertEquals(VIPs, concert.getVIPs());
    }

    @Test
    public void calculateProfitTest()
    {
        double profit = 100 * 100 * 0.6;
        assertEquals(profit, concert.calculateProfit());
    }

    @Test
    public void calculateVIPTest()
    {
        assertEquals(2, concert.calculateVIP());
    }
}
