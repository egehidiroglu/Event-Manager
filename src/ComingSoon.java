import java.time.LocalDate;
import java.util.Optional;

public class ComingSoon implements Event, Profit{

    private String aName;
    private LocalDate aDate;
    private Optional<Location> aLocation;
    private Optional<Double> aPrice;
    private Optional<Integer> aNumTickets;

    public ComingSoon(String pName, LocalDate pDate, Location pLocation, double pPrice, int pNumTickets)
    {
        assert pName!=null && pDate!=null;
        aName = pName;
        aDate = pDate;
        aLocation = Optional.ofNullable(pLocation);
        aPrice = Optional.ofNullable(pPrice);
        aNumTickets = Optional.ofNullable(pNumTickets);
    }

    public ComingSoon(String pName, LocalDate pDate)
    {
        assert pName!=null && pDate!=null;
        aName = pName;
        aDate = pDate;
        aLocation = Optional.empty();
        aPrice = Optional.empty();
        aNumTickets = Optional.empty();
    }

    @Override
    public String getName() {
        return this.aName;
    }

    @Override
    public Location getLocation() {
        return aLocation.orElse(null);
    }

    @Override
    public LocalDate getDate() {
        return this.aDate;
    }

    @Override
    public double getPrice() {
        return aPrice.orElse(0.0);
    }

    @Override
    public int getNumTickets() {
        return aNumTickets.orElse(0);
    }

    @Override
    public double calculateProfit() {
        return 0;
    }

    @Override
    public int calculateVIP() {
        return 0;
    }
}
