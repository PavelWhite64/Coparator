import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("Шереметьево", "Берлин-Бранденбург", 10_000, 12, 14);
    Ticket ticket2 = new Ticket("Шереметьево", "Берлин-Бранденбург", 14_000, 9, 15);
    Ticket ticket3 = new Ticket("Домодедово", "Анталья", 12_000, 8, 14);
    Ticket ticket4 = new Ticket("Шереметьево", "Берлин-Бранденбург", 25_000, 1, 10);
    Ticket ticket5 = new Ticket("Жуковский", "Дерби", 32_000, 3, 13);
    Ticket ticket6 = new Ticket("Шереметьево", "Берлин-Бранденбург", 7_000, 6, 18);
    Ticket ticket7 = new Ticket("Шереметьево", "Берлин-Бранденбург", 5_000, 10, 13);
    Ticket ticket8 = new Ticket("Внуково", "Эсенбога", 18_000, 11, 15);
    Ticket ticket9 = new Ticket("Домодедово", "Анталья", 8_000, 5, 12);
    Ticket ticket10 = new Ticket("Остафьево", "Хинтон-ин-Хеджес", 21_000, 3, 18);
    Ticket ticket11 = new Ticket("Жуковский", "Дерби", 33_000, 7, 15);
    Ticket ticket12 = new Ticket("HR center", "Erie International Airport", 48_000, 3, 18);

    @Test
    public void compareTo1() {

        Assertions.assertEquals(1, ticket4.compareTo(ticket2));
    }

    @Test
    public void compareToMinus1() {

        Assertions.assertEquals(-1, ticket1.compareTo(ticket3));
    }

    @Test
    public void compareTo0() {

        Assertions.assertEquals(0, ticket5.compareTo(ticket5));
    }

    @Test
    public void searchPrise() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);

        Ticket[] expected = {ticket7, ticket6, ticket1, ticket2, ticket4};
        Ticket[] actual = manager.search("Шереметьево", "Берлин-Бранденбург");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ticketComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);

        Ticket[] expected = {ticket1, ticket7, ticket2, ticket4, ticket6};
        Ticket[] actual = manager.searchAndSortBy("Шереметьево", "Берлин-Бранденбург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
