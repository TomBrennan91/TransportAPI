package transport.tickets;

import java.util.ArrayList;

public class TicketFactory {


    public ArrayList<Ticket> createAllTickets(){
        return null;
    }

    private Ticket createTicket(String type) throws UnknownTicketTypeException{

        switch (TicketType.valueOf(type.toUpperCase())){
            case AIRPORT_BUS:
                return new BusTicket();
            case TRAIN:
                return new TrainTicket();
            case Flight:
                return new FlightTicket();
            default:
                throw new UnknownTicketTypeException(type);
        }
    }


}
