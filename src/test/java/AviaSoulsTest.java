import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    @Test
    public void shouldCompareToTicketCorrectIfFirstPriceLess() {
        Ticket firstTicket = new Ticket("", "", 100, 0, 5);
        Ticket secondTicket = new Ticket("", "", 150, 0, 5);

        int expected = -1;
        int actual = firstTicket.compareTo(secondTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToTicketCorrectIfPricesEquals() {
        Ticket firstTicket = new Ticket("", "", 100, 0, 5);
        Ticket secondTicket = new Ticket("", "", 100, 0, 5);

        int expected = 0;
        int actual = firstTicket.compareTo(secondTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToTicketCorrectIfSecondPriceLess() {
        Ticket firstTicket = new Ticket("", "", 100, 0, 5);
        Ticket secondTicket = new Ticket("", "", 50, 0, 5);

        int expected = 1;
        int actual = firstTicket.compareTo(secondTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchCorrectIfNoMatches() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Malta", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = aviaSouls.search("Sochi", "Berlin");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchCorrectIfOnlyOneMatch() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Berlin", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        Ticket[] expected = new Ticket[] { thirdTicket };
        Ticket[] actual = aviaSouls.search("Berlin", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchCorrectIfSeveralMatches() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Berlin", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        Ticket[] expected = new Ticket[] { secondTicket, firstTicket };
        Ticket[] actual = aviaSouls.search("Malta", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortCorrectIfEveryoneMatches() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Malta", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        Ticket[] expected = new Ticket[] { secondTicket, firstTicket, thirdTicket };
        Ticket[] actual = aviaSouls.search("Malta", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareCorrectIfFirstFlightTimeLess() {
        Ticket firstTicket = new Ticket("", "", 100, 0, 3);
        Ticket secondTicket = new Ticket("", "", 150, 0, 5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(firstTicket, secondTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareCorrectIfFlightTimesEquals() {
        Ticket firstTicket = new Ticket("", "", 100, 0, 3);
        Ticket secondTicket = new Ticket("", "", 150, 0, 3);

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(firstTicket, secondTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareCorrectIfSecondFlightTimeLess() {
        Ticket firstTicket = new Ticket("", "", 100, 0, 3);
        Ticket secondTicket = new Ticket("", "", 150, 0, 2);

        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(firstTicket, secondTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortCorrectIfNoMatches() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Malta", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = aviaSouls.searchAndSortBy("Sochi", "Berlin", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortCorrectIfOnlyOneMatch() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Berlin", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = new Ticket[] { thirdTicket };
        Ticket[] actual = aviaSouls.searchAndSortBy("Berlin", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortCorrectIfSeveralMatches() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Berlin", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = new Ticket[] { firstTicket, secondTicket };
        Ticket[] actual = aviaSouls.searchAndSortBy("Malta", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortAndSortCorrectIfEveryoneMatches() {
        Ticket firstTicket = new Ticket("Malta", "Moscow", 200, 0, 5);
        Ticket secondTicket = new Ticket("Malta", "Moscow", 150, 0, 10);
        Ticket thirdTicket = new Ticket("Malta", "Moscow", 250, 0, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(firstTicket);
        aviaSouls.add(secondTicket);
        aviaSouls.add(thirdTicket);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = new Ticket[] { thirdTicket, firstTicket, secondTicket };
        Ticket[] actual = aviaSouls.searchAndSortBy("Malta", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
