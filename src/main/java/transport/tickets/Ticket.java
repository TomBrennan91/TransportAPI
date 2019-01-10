package transport.tickets;

import java.util.HashMap;

public abstract class Ticket {
    private String source;
    private String destination;
    TicketType type;
    private String seat;
    private String vehicleName;



    Ticket(HashMap<String, String> rawTicket) {
        this.source = rawTicket.get("source");
        this.destination = rawTicket.get("destination");
        this.seat = rawTicket.get("seat");
        this.vehicleName = rawTicket.get("vehicleName");
    }

    public String getItinerarySectionDescription(){
        return "Take the " + type.getPrintableName()
                + getVehicleName()
                + " from " + source
                + " to " + destination + "."
                + getSeatDescription();
    }

    private String getSeatDescription(){
        if (seat == null){
            return " No seat assignment.";
        } else {
            return " Sit in seat " + seat + ".";
        }
    }

    private String getVehicleName(){
        if (vehicleName == null){
            return "";
        } else {
            return " " + vehicleName;
        }
    }
}
