package transport.tickets;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketFactoryTest {

    @Test
    public void nullTicketList() throws UnknownTicketTypeException{
        assertEquals(null, TicketFactory.createAllTickets(null));
    }

    @Test
    public void emptyTicketList() throws UnknownTicketTypeException{
        assertEquals(null, TicketFactory.createAllTickets(new ArrayList<>()));
    }

    @Test
    public void unknownTicketType(){
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("type","foo");
        ArrayList<HashMap<String,String>> errorList = new ArrayList<>();
        errorList.add(errorMap);
        assertThrows(UnknownTicketTypeException.class, () -> {TicketFactory.createAllTickets(errorList); });
    }

    @Test
    public void flightTicket(){
        HashMap<String, String> map = new HashMap<>();
        map.put("type","Flight");
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        list.add(map);
        ArrayList<Ticket> tickets = TicketFactory.createAllTickets(list);
        assertEquals(TicketType.FLIGHT,tickets.get(0).type);
    }

    @Test
    public void TrainTicket(){
        HashMap<String, String> map = new HashMap<>();
        map.put("type","Train");
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        list.add(map);
        ArrayList<Ticket> tickets = TicketFactory.createAllTickets(list);
        assertEquals(TicketType.TRAIN,tickets.get(0).type);
    }

    @Test
    public void BusTicket(){
        HashMap<String, String> map = new HashMap<>();
        map.put("type","Airport Bus");
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        list.add(map);
        ArrayList<Ticket> tickets = TicketFactory.createAllTickets(list);
        assertEquals(TicketType.AIRPORT_BUS,tickets.get(0).type);
    }

}