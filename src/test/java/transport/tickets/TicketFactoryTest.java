package transport.tickets;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

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
}