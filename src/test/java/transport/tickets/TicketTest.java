package transport.tickets;

import org.junit.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    public void ticketValidNullTicketTest(){
        Ticket ticket = new BusTicket(null);
        assertFalse(ticket.isValid());
    }

    @Test
    public void ticketValidEmptyTicketTest(){
        HashMap<String, String> rawTicket = new HashMap<>();
        rawTicket.put("source","  ");
        rawTicket.put("destination","b");
        Ticket ticket = new BusTicket(rawTicket);
        assertFalse(ticket.isValid());
    }

    @Test
    public void ticketValidateNullParameterTest(){
        HashMap<String, String> rawTicket = new HashMap<>();
        rawTicket.put("source","a");
        rawTicket.put("destination",null);
        Ticket ticket = new BusTicket(rawTicket);
        assertFalse(ticket.isValid());
    }


    @Test
    public void ticketValidationAcceptanceTest(){
        HashMap<String, String> rawTicket = new HashMap<>();
        rawTicket.put("source","a");
        rawTicket.put("destination","b");
        Ticket ticket = new BusTicket(rawTicket);
        assertTrue(ticket.isValid());
    }

}