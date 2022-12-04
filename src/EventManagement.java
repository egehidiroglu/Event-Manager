import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Controller to manage events hosted on EventBrite.
 */
public class EventManagement {

    private List<Event> aHostedEvents = new ArrayList<Event>();

    /*
    Method to host a new concert event
     */

    /**
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pArtist
     * @param pVIPs
     *
     * @post aHostedEvents.get(aHostedEvents.size()-1) == concert event
     */
    public void addConcertEvent(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, String pArtist, List<String> pVIPs){
        Event concert = EventFactory.createConcert(pName, pLocation, pDate, pPrice, pNumTickets, pArtist, pVIPs);

        if (!isPresent(concert))
        {
            aHostedEvents.add(concert);
        }
    }

    private boolean isPresent(Event pEvent)
    {
        for (Event event : aHostedEvents)
        {
            if (event.hashCode() == pEvent.hashCode())
            {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pArtist
     * @param pVIPs
     *
     * @return concert with given parameters
     */
    public Event createConcert(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, String pArtist, List<String> pVIPs)
    {
        return EventFactory.createConcert(pName, pLocation, pDate, pPrice, pNumTickets, pArtist, pVIPs);
    }

    /*
    Method to host a new Gala event
     */

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pVIPs
     *
     * @post aHostedEvents.get(aHostedEvents.size()-1) == gala event
     */
    public void addGalaEvent(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<String> pVIPs){
        Event gala = EventFactory.createGala(pName, pLocation, pDate, pPrice, pNumTickets, pVIPs);

        if (!isPresent(gala))
        {
            aHostedEvents.add(gala);
        }

    }

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pVIPs
     *
     * @return gala event with given parameters
     */
    public Event createGala(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<String> pVIPs)
    {
        return EventFactory.createGala(pName, pLocation, pDate, pPrice, pNumTickets, pVIPs);
    }

    /*
    Method to host a new Screening event
     */

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pRating
     *
     * @post aHostedEvents.get(aHostedEvents.size()-1) == screening event
     */
    public void addScreeningEvent(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, Rating pRating){
        Event screening = EventFactory.createScreening(pName, pLocation, pDate, pPrice, pNumTickets, pRating);

        if (!isPresent(screening))
        {
            aHostedEvents.add(screening);
        }
    }

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pRating
     * @return screening event with given parameters
     */
    public Event createScreening(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, Rating pRating)
    {
        return EventFactory.createScreening(pName, pLocation, pDate, pPrice, pNumTickets, pRating);
    }

    /*
    Method to host a new Workshop event
     */

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pPrereq
     *
     * @post aHostedEvents.get(aHostedEvents.size()-1) == workshop event
     */
    public void addWorkshopEvent(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<Workshop> pPrereq){
        Event workshop = EventFactory.createWorkshop(pName, pLocation, pDate, pPrice, pNumTickets, pPrereq);

        if (!isPresent(workshop))
        {
            aHostedEvents.add(workshop);
        }
    }

    /**
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pPrereq
     * @return workshop event with given parameters
     */
    public Event createWorkshop(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<Workshop> pPrereq)
    {
        return EventFactory.createWorkshop(pName, pLocation, pDate, pPrice, pNumTickets, pPrereq);
    }

    /**
     * @param pName
     * @param pEvents
     *
     * @post aHostedEvents.get(aHostedEvents.size()-1) == festival event
     */
    public void addFestivalEvent(String pName, List<Event> pEvents)
    {
        Festival festival = new Festival(pName, pEvents);

        if (!isPresent(festival))
        {
            aHostedEvents.add(festival);
        }
    }

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     *
     * @post aHostedEvents.get(aHostedEvents.size()-1) == coming soon event
     */
    public void addComingSoonEvent(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets)
    {
        Event comingSoon = new ComingSoon(pName, pDate, pLocation, pPrice, pNumTickets);

        if (!isPresent(comingSoon))
        {
            aHostedEvents.add(comingSoon);
        }

    }

    /**
     *
     * @param index
     *
     * @pre index>=0 && index < aHostedEvents.size()
     */
    public void removeEvent(int index)
    {
        assert index >= 0 && index < aHostedEvents.size();
        System.out.println("Removing Event " + aHostedEvents.get(index).getName());
        aHostedEvents.remove(index);
    }

    /**
     * @return the total profit of events in aHostedEvents
     */
    public double calculateTotalProfit()
    {
        double profit = 0;

        for (Event event : aHostedEvents)
        {
            profit+=event.calculateProfit();
        }

        return profit;
    }

    /**
     * @return the total profit of concert events in aHostedEvents
     */
    public double calculateConcertProfit()
    {
        double profit = 0;

        for (Event event : aHostedEvents)
        {
            if (event instanceof Concert)
            {
                profit += ((Concert) event).calculateProfit();
            }
        }

        return profit;
    }

    /**
     * @return the total profit of gala events in aHostedEvents
     */
    public double calculateGalaProfit()
    {
        double profit = 0;

        for (Event event : aHostedEvents)
        {
            if (event instanceof Gala)
            {
                profit += ((Gala) event).calculateProfit();
            }
        }

        return profit;
    }

    /**
     * @return the total profit of screening events in aHostedEvents
     */
    public double calculateScreeningProfit()
    {
        double profit = 0;

        for (Event event : aHostedEvents)
        {
            if (event instanceof Screening)
            {
                profit += ((Screening) event).calculateProfit();
            }
        }

        return profit;
    }

    /**
     * @return the total profit of workshop events in aHostedEvents
     */
    public double calculateWorkshopProfit()
    {
        double profit = 0;

        for (Event event : aHostedEvents)
        {
            if (event instanceof Workshop)
            {
                profit += ((Workshop) event).calculateProfit();
            }
        }

        return profit;
    }

    /**
     * @return the total profit of festival events in aHostedEvents
     */
    public double calculateFestivalProfit()
    {
        double profit = 0;

        for (Event event : aHostedEvents)
        {
            if (event instanceof Festival)
            {
                profit += ((Festival) event).calculateProfit();
            }
        }

        return profit;
    }

    /**
     * Prints the total profit and profit from each event
     */
    public void profitReport()
    {
        System.out.println("==========Profit Report==========");
        System.out.println("Concert Profit: " + calculateConcertProfit());
        System.out.println("Gala Profit: " + calculateGalaProfit());
        System.out.println("Screening Profit: " + calculateScreeningProfit());
        System.out.println("Workshop Profit: " + calculateWorkshopProfit());
        System.out.println("Festival Profit: " + calculateFestivalProfit());
        System.out.println("Total Profit: " + calculateTotalProfit());
        System.out.println("=================================");

    }

    /*
    Return the list of hosted events on EventBrite.
    This method assumes that Events are immutable.
     */
    public ArrayList<Event> getHostedEvents(){
        return new ArrayList<Event>(aHostedEvents);
    }
}
