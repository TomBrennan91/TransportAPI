package transport.sorting;

import org.junit.Test;
import transport.tickets.BusTicket;
import transport.tickets.Ticket;
import transport.tickets.TicketFactory;
import transport.tickets.UnknownTicketTypeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TicketSorterTest {

    @Test
    public void sortEmptyList(){
        assertEquals(TicketSorter.sortTickets(new ArrayList<>()), new ArrayList<>()) ;
    }

    @Test
    public void sortNull(){
        assertNull(TicketSorter.sortTickets(null));
    }

    @Test
    public void sortSingleTicket(){
        Ticket ticket = new BusTicket(null);
        ArrayList<Ticket> listOfOne = new ArrayList<>();
        listOfOne.add(ticket);
        assertEquals(TicketSorter.sortTickets(listOfOne), listOfOne);
    }

    @Test
    public void sortMultipleTickets()throws UnknownTicketTypeException {

        ArrayList<HashMap<String, String>> unsortedMap = new ArrayList<>();

        HashMap<String,String> ab = new HashMap<>();
        ab.put("source","a");
        ab.put("destination","b");
        ab.put("type","Airport Bus");

        HashMap<String,String> bc = new HashMap<>();
        bc.put("source","b");
        bc.put("destination","c");
        bc.put("type","Airport Bus");

        HashMap<String,String> cd = new HashMap<>();
        cd.put("source","c");
        cd.put("destination","d");
        cd.put("type","Airport Bus");

        unsortedMap.add(bc);
        unsortedMap.add(cd);
        unsortedMap.add(ab);

        ArrayList<Ticket> unsortedTickets = TicketFactory.createAllTickets(unsortedMap);

        List<Ticket> sortedTickets = TicketSorter.sortTickets(unsortedTickets);

        assertEquals(sortedTickets.get(0).getSource(),"a");
        assertEquals(sortedTickets.get(0).getDestination(),"b");
        assertEquals(sortedTickets.get(1).getSource(),"b");
        assertEquals(sortedTickets.get(1).getDestination(),"c");
        assertEquals(sortedTickets.get(2).getSource(),"c");
        assertEquals(sortedTickets.get(2).getDestination(),"d");
    }
}