import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class EventFactory {

    private static HashMap<LocalDate, Event> dateMap = new HashMap<>();
    private static HashMap<Location, Event> locationMap = new HashMap<>();

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
     * @pre pDate!=null && pLocation!=null
     *
     * @return the newly created event or the event that already exists with that date and location
     */
    public static Event createConcert(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, String pArtist, List<String> pVIPs)
    {
        assert pDate!=null && pLocation!=null;
        Event concert = dateMap.get(pDate);
        Event concert1 = locationMap.get(pLocation);

        if (concert == null || concert1 == null)
        {
            concert = new Concert(pName, pLocation, pDate, pPrice, pNumTickets, pArtist, pVIPs);
            concert1 = concert;
            dateMap.put(pDate, concert);
            locationMap.put(pLocation, concert);
        }

        return concert;
    }

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pPrereq
     * @return the newly created event or the event that already exists with that date and location
     *
     * @pre pDate!=null && pLocation!=null
     */
    public static Event createWorkshop(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<Workshop> pPrereq)
    {
        assert pDate!=null && pLocation!=null;
        Event workshop = dateMap.get(pDate);
        Event workshop1 = locationMap.get(pLocation);

        if (workshop == null || workshop1 == null)
        {
            workshop = new Workshop(pName, pLocation, pDate, pPrice, pNumTickets, pPrereq);
            workshop1 = workshop;
            dateMap.put(pDate, workshop);
            locationMap.put(pLocation, workshop);
        }

        return workshop;
    }

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pVIPs
     * @return the newly created event or the event that already exists with that date and location
     *
     * @pre pDate!=null && pLocation!=null
     */
    public static Event createGala(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, List<String> pVIPs)
    {
        assert pDate!=null && pLocation!=null;

        Event gala = dateMap.get(pDate);
        Event gala1 = locationMap.get(pLocation);

        if (gala == null || gala1 == null)
        {
            gala = new Gala(pName, pLocation, pDate, pPrice, pNumTickets, pVIPs);
            gala1 = gala;
            dateMap.put(pDate, gala);
            locationMap.put(pLocation, gala);
        }

        return gala;
    }

    /**
     *
     * @param pName
     * @param pLocation
     * @param pDate
     * @param pPrice
     * @param pNumTickets
     * @param pRating
     * @return the newly created event or the event that already exists with that date and location
     *
     * @pre pDate!=null && pLocation!=null
     */
    public static Event createScreening(String pName, Location pLocation, LocalDate pDate, double pPrice, int pNumTickets, Rating pRating)
    {
        assert pDate!=null && pLocation!=null;

        Event screening = dateMap.get(pDate);
        Event screening1 = locationMap.get(pLocation);

        if (screening == null || screening1 == null)
        {
            screening = new Screening(pName, pLocation, pDate, pPrice, pNumTickets, pRating);
            screening1 = screening;
            dateMap.put(pDate, screening);
            locationMap.put(pLocation, screening);
        }

        return screening;
    }

}
