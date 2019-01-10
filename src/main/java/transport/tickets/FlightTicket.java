package transport.tickets;

import java.util.HashMap;

public class FlightTicket extends Ticket{

    private String baggageDropCounter;
    private String boardingGate;
    private String vehicleName;

    public FlightTicket(HashMap<String, String> rawTicket) {
        super(rawTicket);
        this.vehicleName = rawTicket.get("vehiclename");
        this.baggageDropCounter = rawTicket.get("baggagedropcounter");
        this.boardingGate = rawTicket.get("boardinggate");
    }

    @Override
    public String getItinerarySectionDescription(){
        return super.getItinerarySectionDescription() + getBoardingGateDescription() + getBaggageDropDescription();
    }

    private String getBoardingGateDescription(){
        return  " Gate " + boardingGate + ".";
    }

    private String getBaggageDropDescription(){
        if (baggageDropCounter == null){
            return "Baggage will be Automatically transferred from your last leg";
        } else {
            return " Baggage drop at ticket counter " + baggageDropCounter + ".";
        }
    }

}
