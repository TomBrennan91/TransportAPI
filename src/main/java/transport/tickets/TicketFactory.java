package transport.tickets;

import java.util.ArrayList;
import java.util.HashMap;

public class TicketFactory {

    public static ArrayList<Ticket> createAllTickets(ArrayList<HashMap<String, String>> inputStack)throws  UnknownTicketTypeException{
        if (inputStack == null || inputStack.size() == 0 ) return null;
        ArrayList<Ticket> ticketList = new ArrayList<>();
        for (HashMap<String,String> rawTicket : inputStack){
            ticketList.add(createTicket(rawTicket));
        }
        return ticketList;
    }

    private static Ticket createTicket(HashMap<String, String> rawData) throws UnknownTicketTypeException{
        String type = rawData.get("type");
        try {
            switch (TicketType.valueOf(type.replace(" ", "_").toUpperCase())) {
                case AIRPORT_BUS:
                    return new BusTicket(rawData);
                case TRAIN:
                    return new TrainTicket(rawData);
                case FLIGHT:
                    return new FlightTicket(rawData);
                default:
                    throw new UnknownTicketTypeException(type);
            }
        } catch (IllegalArgumentException e){
            throw new UnknownTicketTypeException(type);
        }
    }


}
