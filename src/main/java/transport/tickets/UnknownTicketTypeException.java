package transport.tickets;

class UnknownTicketTypeException extends RuntimeException{
    UnknownTicketTypeException(String ticketType){
        System.err.println("Unknown Ticket Type : " + ticketType);
    }
}
