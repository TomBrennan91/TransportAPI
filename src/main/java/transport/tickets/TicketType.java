package transport.tickets;

public enum TicketType {
    AIRPORT_BUS ("Airport Bus"),
    Flight("Flight"),
    TRAIN("Train");

    public String getPrintableName() {
        return this.printableName;
    }

    private String printableName;

    TicketType(String printableName){
        this.printableName = printableName;
    }
}
