package transport.tickets;

import java.util.HashMap;

class BusTicket extends Ticket{
    BusTicket(HashMap<String, String> rawTicket) {
        super(rawTicket);
        this.type = TicketType.AIRPORT_BUS;
    }
}
