package transport;

import simplejson.NaiveJsonParser;
import transport.io.TicketFileInput;
import transport.io.TicketPrinter;
import transport.sorting.TicketSorter;
import transport.tickets.Ticket;
import transport.tickets.TicketFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String json = "";
        try {
            json = TicketFileInput.getJsonFromPath("./src/main/resources/exampleTickets.json");
        } catch (IOException e){
            e.printStackTrace();
        }

        ArrayList<HashMap<String, String>> tickets =  NaiveJsonParser.getTicketsFromJson(json);

        ArrayList<Ticket> ticketList =  TicketFactory.createAllTickets(tickets);
        List<Ticket> sortedTickets = TicketSorter.sortTickets(ticketList);
        TicketPrinter.printTickets(sortedTickets);
    }
}
