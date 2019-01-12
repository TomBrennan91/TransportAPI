package transport.tickets;

public class UnknownTicketTypeException extends Exception{
    UnknownTicketTypeException(String ticketType){
        super("Unknown Ticket Type : " + ticketType);
    }
}
