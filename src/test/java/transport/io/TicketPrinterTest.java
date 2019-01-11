package transport.io;

import org.junit.jupiter.api.*;
import transport.tickets.BusTicket;
import transport.tickets.Ticket;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TicketPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void emptyTicketStack(){
        TicketPrinter.printTickets(new LinkedList<>());
        assertEquals("1. You have arrived at your destination.\r\n", outContent.toString());
    }


    @Test
    public void mockTicketStack(){

        Ticket t1 = new BusTicket(new HashMap<>());
        Ticket t2 = new BusTicket(new HashMap<>());
        List<Ticket> mockList= new LinkedList<>();
        mockList.add(t1);
        mockList.add(t2);

        TicketPrinter.printTickets(mockList);
        assertEquals(
                "1. Take the Airport Bus from null to null. No seat assignment.\r\n"+
                         "2. Take the Airport Bus from null to null. No seat assignment.\r\n"+
                         "3. You have arrived at your destination.\r\n", outContent.toString());
    }
}