package transport.tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class Ticket {

    TicketType type;
    private String source;
    private String destination;
    private String seat;
    private String vehicleName;

    Ticket(HashMap<String, String> rawTicket) {
        if (rawTicket == null) return;
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

    public boolean isValid(){
        ArrayList<String> mandatoryParameters = new ArrayList<>();
        mandatoryParameters.add(type.toString());
        mandatoryParameters.add(source);
        mandatoryParameters.add(destination);

        return mandatoryParameters.stream().noneMatch( s -> s == null || s.trim().isEmpty());
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

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "type=" + type +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
