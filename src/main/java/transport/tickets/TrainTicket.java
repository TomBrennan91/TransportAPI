package transport.tickets;

import java.util.HashMap;

class TrainTicket extends Ticket{

    TrainTicket(HashMap<String, String> rawTicket) {
        super(rawTicket);
        this.type = TicketType.TRAIN;
    }
}
