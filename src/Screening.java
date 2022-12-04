import java.time.LocalDate;

public class Screening extends ConcreteEvent implements Profit, Vip{

    private Rating aRating;

    public Screening(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, Rating pRating) {
        super(pName, pLocation, pDate, pPrice, pNumTickets);
        assert pRating!=null;
        this.aRating = pRating;
    }

    /**
     * @return the rating of the screening
     */
    public Rating getRating()
    {
        return this.aRating;
    }

    /**
     * @param pRating
     *
     * @pre pRating!=null
     * @post aRating = pRating
     */
    public void setRating(Rating pRating)
    {
        assert pRating!=null;
        this.aRating = pRating;
    }

    /**
     * @return the profit of the screening event based on profit percentage.
     */
    public double calculateProfit()
    {
        return getPrice() * getNumTickets() * 0.1;
    }

    public int calculateVIP()
    {
        return 0;
    }
}
