package transport.tickets;

public class UnknownTicketTypeException extends Exception{
    UnknownTicketTypeException(String ticketType){
        System.err.println("Unknown Ticket Type : " + ticketType);
    }


}
