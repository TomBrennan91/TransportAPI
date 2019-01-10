package transport.tickets;

public class FlightTicket extends Ticket{

    private String baggageDropCounter;
    private String boardingGate;
    private String vehicleName;

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
