package transport.tickets;

import java.util.HashMap;

public class TrainTicket extends Ticket{

    private String vehicle;

    public TrainTicket(HashMap<String, String> rawTicket) {
        super(rawTicket);
    }

    public String getItinerarySectionDescription() {
        return null;
    }
}
