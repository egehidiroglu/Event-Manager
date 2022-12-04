import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gala extends ConcreteEvent implements Profit, Vip{

    private List<String> aVIPs;

    public Gala(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<String> pVIPs) {
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        assert pVIPs!=null;
        this.aVIPs = pVIPs;
    }

    /**
     * @return the list of VIPs
     */
    public List<String> getVIPs()
    {
        return new ArrayList<>(aVIPs);
    }

    /**
     * @param pVIPs
     *
     * @pre pVIPs != null
     * @post aVIPs = pVIPs
     */
    public void setVIPs(List<String> pVIPs)
    {
        assert pVIPs!=null;
        this.aVIPs = pVIPs;
    }

    /**
     *
     * @return the profit of the gala event based on the profit percentage
     */
    public double calculateProfit()
    {
        return getPrice() * getNumTickets() * 0.3;
    }

    @Override
    public int calculateVIP() {
        return aVIPs.size();
    }
}
