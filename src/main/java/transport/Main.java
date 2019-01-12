package transport;

import transport.simplejson.NaiveJsonParser;
import transport.io.TicketFileInput;
import transport.io.TicketPrinter;
import transport.sorting.TicketSorter;
import transport.tickets.InvalidTicketException;
import transport.tickets.Ticket;
import transport.tickets.TicketFactory;
import transport.tickets.UnknownTicketTypeException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String filePath;
        if (args == null || args.length == 0){
            filePath = "./src/main/resources/exampleTickets.json";
        } else {
            filePath = args[0];
        }

        try {
            createAndPrintItinerary(filePath);
        } catch (InvalidTicketException | UnknownTicketTypeException| IOException e){
            e.printStackTrace();
        }

    }

    private static void createAndPrintItinerary(String filePath) throws IOException, InvalidTicketException, UnknownTicketTypeException{

        String json = TicketFileInput.getJsonFromPath(filePath);
        ArrayList<HashMap<String, String>> rawTickets =  NaiveJsonParser.getRawTicketsFromJson(json);
        ArrayList<Ticket> ticketList =  TicketFactory.createAllTickets(rawTickets);
        Optional<Ticket> invalidTicket = ticketList.stream().filter(ticket -> !ticket.isValid()).findAny();
        if (invalidTicket.isPresent()){
            throw new InvalidTicketException(invalidTicket.get());
        }
        List<Ticket> sortedTickets = TicketSorter.sortTickets(ticketList);
        TicketPrinter.printTickets(sortedTickets);
    }
}
