package transport.io;

import transport.tickets.Ticket;

import java.util.List;

public class TicketPrinter {
    public static void printTickets(List<Ticket> sortedTickets){
        int ticketNo = 0;
        for (Ticket ticket : sortedTickets){
            System.out.println(++ticketNo + ". " + ticket.getItinerarySectionDescription());
        }
        System.out.println(++ticketNo + ". You have arrived at your destination.");
    }
}
