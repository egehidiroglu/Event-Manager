import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GalaTest {

    private Gala gala;

    @BeforeEach
    public void setUp()
    {
        List<String> VIPs = new ArrayList<>();
        VIPs.add("John");
        VIPs.add("James");
        gala = new Gala("Gala", Location.PlaceDesArts, LocalDate.now(), 100, 100, VIPs);
    }

    @Test
    public void calculateProfitTest()
    {
        double expected = 100*100*0.3;
        double actual = gala.calculateProfit();

        assertEquals(expected, actual);
    }

    @Test
    public void calculateVIPTest()
    {
        int expected = 2;
        int actual = gala.calculateVIP();

        assertEquals(expected, actual);
    }

    @Test
    public void getVIPsTest()
    {
        List<String> VIPs = new ArrayList<>();
        VIPs.add("John");
        VIPs.add("James");

        for (int i=0; i<gala.getVIPs().size(); i++)
        {
            assertEquals(VIPs.get(i), gala.getVIPs().get(i));
        }
    }

    @Test
    public void setVIPsTest()
    {
        List<String> VIPs = new ArrayList<>();
        VIPs.add("Timothy");
        VIPs.add("Jonas");

        gala.setVIPs(VIPs);

        for (int i=0; i<gala.getVIPs().size(); i++)
        {
            assertEquals(VIPs.get(i), gala.getVIPs().get(i));
        }
    }
}
