package transport.tickets;

public class InvalidTicketException extends Exception {
    public InvalidTicketException(Ticket brokenTicket) {
        super("Invalid Ticket: " + brokenTicket.toString());
    }
}
