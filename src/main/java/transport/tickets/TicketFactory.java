package transport.tickets;

public class TicketFactory {

    public Ticket createTicket(String type){

        switch (TicketType.valueOf(type.toUpperCase())){
            case AIRPORT_BUS:
                return new BusTicket();
            case TRAIN:
                return new TrainTicket();
            case FLIGHT:
                return new FlightTicket();

            }
        }
    }

}
