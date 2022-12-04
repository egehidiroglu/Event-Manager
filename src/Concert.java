import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concert extends ConcreteEvent implements Profit, Vip{

    private String aArtist;
    private List<String> aVIPs;

    public Concert(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, String pArtist, List<String> pVIPs) {
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        assert pArtist!=null && pVIPs!=null;
        this.aArtist = pArtist;
        this.aVIPs = pVIPs;
    }

    /**
     * @return The name of the artist.
     */
    public String getArtist()
    {
        return this.aArtist;
    }

    /**
     * Sets the name of the Artist.
     *
     * @param pArtist
     *
     * @pre pArtist != null
     * @post aArtist = pArtist
     */
    public void setArtist(String pArtist)
    {
        assert pArtist!=null;
        this.aArtist = pArtist;
    }

    /**
     * @return Returns a copy of the list of VIPs.
     */
    public List<String> getVIPs()
    {
        return new ArrayList<>(aVIPs);
    }

    /**
     * Sets the list of the VIPs to the given list.
     *
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
     * @return The profit of the event
     */
    public double calculateProfit()
    {
        return getPrice() * getNumTickets() * 0.6;
    }

    @Override
    public int calculateVIP() {
        return aVIPs.size();
    }
}
