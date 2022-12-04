import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Workshop extends ConcreteEvent implements Profit, Vip{

    private List<Workshop> aPrereqs;

    public Workshop(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<Workshop> pPrereqs) {
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        assert pPrereqs!=null;
        this.aPrereqs = pPrereqs;
    }

    /**
     * @return the list of prerequisite workshops
     */
    public List<Workshop> getPrereqs()
    {
        return new ArrayList<>(aPrereqs);
    }

    /**
     * @param pPrereqs
     *
     * @pre pPrereqs != null
     * @post aPrereqs = pPrereqs
     */
    public void setPrereqs(List<Workshop> pPrereqs)
    {
        assert pPrereqs!=null;
        this.aPrereqs = pPrereqs;
    }

    /**
     * @return the profit of the workshop event based on profit peercentage
     */
    public double calculateProfit()
    {
        return getPrice() * getNumTickets() * 0.5;
    }

    public int calculateVIP()
    {
        return 0;
    }
}
