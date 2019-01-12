package transport.io;

import transport.tickets.Ticket;

import java.util.List;

public class TicketPrinter {
    public static String printTickets(List<Ticket> sortedTickets){
        StringBuilder out = new StringBuilder();
        int ticketNo = 0;
        for (Ticket ticket : sortedTickets){
            out.append(++ticketNo + ". " + ticket.getItinerarySectionDescription() + "\n");
        }
        out.append(++ticketNo + ". You have arrived at your destination.");
        return out.toString();
    }
}
