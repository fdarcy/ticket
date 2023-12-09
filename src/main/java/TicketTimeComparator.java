import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        int firstTicketFlightTime = o1.getTimeTo() - o1.getTimeFrom();
        int secondTicketFlightTime = o2.getTimeTo() - o2.getTimeFrom();

        if (firstTicketFlightTime < secondTicketFlightTime) {
            return -1;
        }
        else if (firstTicketFlightTime > secondTicketFlightTime) {
            return 1;
        }

        return 0;
    }
}
