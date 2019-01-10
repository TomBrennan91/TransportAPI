package transport.tickets;

public class TicketFactory {

    public Ticket createTicket(String type) throws UnknownTicketTypeException{

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

}
