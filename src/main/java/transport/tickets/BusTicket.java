package transport.tickets;

import java.util.HashMap;

public class BusTicket extends Ticket{
    public BusTicket(HashMap<String, String> rawTicket) {
        super(rawTicket);
        this.type = TicketType.AIRPORT_BUS;
    }
}
