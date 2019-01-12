package transport.tickets;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TicketFactoryTest {

    @Test
    public void nullTicketList() throws UnknownTicketTypeException{
        assertNull(TicketFactory.createAllTickets(null));
    }

    @Test
    public void emptyTicketList() throws UnknownTicketTypeException{
        assertNull(TicketFactory.createAllTickets(new ArrayList<>()));
    }

    @Test
    public void unknownTicketType(){
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("type","foo");
        ArrayList<HashMap<String,String>> errorList = new ArrayList<>();
        errorList.add(errorMap);
        assertThrows(UnknownTicketTypeException.class, () -> TicketFactory.createAllTickets(errorList));
    }

    @Test
    public void flightTicket() throws UnknownTicketTypeException{
        HashMap<String, String> map = new HashMap<>();
        map.put("type","Flight");
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        list.add(map);
        ArrayList<Ticket> tickets = TicketFactory.createAllTickets(list);
        assertEquals(TicketType.FLIGHT,tickets.get(0).type);
    }

    @Test
    public void TrainTicket() throws UnknownTicketTypeException{
        HashMap<String, String> map = new HashMap<>();
        map.put("type","Train");
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        list.add(map);
        ArrayList<Ticket> tickets = TicketFactory.createAllTickets(list);
        assertEquals(TicketType.TRAIN,tickets.get(0).type);
    }

    @Test
    public void BusTicket() throws UnknownTicketTypeException{
        HashMap<String, String> map = new HashMap<>();
        map.put("type","Airport Bus");
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        list.add(map);
        ArrayList<Ticket> tickets = TicketFactory.createAllTickets(list);
        assertEquals(TicketType.AIRPORT_BUS,tickets.get(0).type);
    }

}