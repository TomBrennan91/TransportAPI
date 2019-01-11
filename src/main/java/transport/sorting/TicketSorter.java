package transport.sorting;

import transport.tickets.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TicketSorter{

    public static List<Ticket> sortTickets(ArrayList<Ticket> unsortedTickets){
        if (unsortedTickets == null || unsortedTickets.size() <= 1) return unsortedTickets;

        LinkedList<Ticket> sortedTickets = new LinkedList<>();
        TicketMap ticketMap = new TicketMap(unsortedTickets);


        //pick a random ticket as a starting point
        Ticket startingTicket = unsortedTickets.get(0);
        Ticket currentTicket = startingTicket;
        sortedTickets.add(currentTicket);

        //iterate through until we reach the final destination
        while (ticketMap.sources.containsKey(currentTicket.getDestination())){
            currentTicket = ticketMap.sources.get(currentTicket.getDestination());
            sortedTickets.addLast(currentTicket);
        }

        //now go back to the starting point and iterate to the beginning of the journey
        currentTicket = startingTicket;
        while (ticketMap.destinations.containsKey(currentTicket.getSource())){
            currentTicket = ticketMap.destinations.get(currentTicket.getSource());
            sortedTickets.addFirst(currentTicket);
        }

        return sortedTickets;
    }

    private static class TicketMap{
        HashMap<String, Ticket> sources = new HashMap<>();
        HashMap<String, Ticket> destinations= new HashMap<>();

        private TicketMap(ArrayList<Ticket> unsortedTickets){
            unsortedTickets.forEach(ticket -> this.sources.put(ticket.getSource(),ticket));
            unsortedTickets.forEach(ticket -> this.destinations.put(ticket.getDestination(),ticket));
        }
    }
}
