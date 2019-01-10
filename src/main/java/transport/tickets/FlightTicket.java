package transport.tickets;

import java.util.HashMap;

class FlightTicket extends Ticket{

    private String baggageDropCounter;
    private String boardingGate;

    FlightTicket(HashMap<String, String> rawTicket) {
        super(rawTicket);
        this.type = TicketType.FLIGHT;
        this.baggageDropCounter = rawTicket.get("baggageDropCounter");
        this.boardingGate = rawTicket.get("boardingGate");
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
            return " Baggage will be automatically transferred from your last leg.";
        } else {
            return " Baggage drop at ticket counter " + baggageDropCounter + ".";
        }
    }

}
