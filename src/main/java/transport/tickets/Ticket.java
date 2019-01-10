package transport.tickets;

abstract class Ticket {
    private String source;
    private String destination;
    private TicketType type;
    private String seat;

    private String getSeatDescription(){
        if (seat == null){
            return " No seat assignment.";
        } else {
            return " Sit in seat " + seat + ".";
        }
    }

    public String getItinerarySectionDescription(){
        return "Take the " + type.getPrintableName() + " from " + source + " to " + destination + "." + getSeatDescription();
    };
}
