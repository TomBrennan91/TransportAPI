package transport;

import org.springframework.web.bind.annotation.*;
import transport.io.TicketFileInput;
import transport.io.TicketPrinter;
import transport.simplejson.NaiveJsonParser;
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

@RestController
public class ItineraryController {


    @CrossOrigin
    @PostMapping("/itinerary")
    public String Itinerary(@RequestBody String input){

        System.out.println("it was run");
        System.out.println(input);

        String response;
        try{
            response =  printItineraryFromJson(input);
        } catch (InvalidTicketException| UnknownTicketTypeException e){
            response = e.getMessage();
        }

        return response;

    }


    private static String printItineraryFromJson(String json) throws InvalidTicketException, UnknownTicketTypeException {

        ArrayList<HashMap<String, String>> rawTickets =  NaiveJsonParser.getRawTicketsFromJson(json);
        if (rawTickets.size() == 0) return "Please enter data in JSON Format";
        ArrayList<Ticket> ticketList =  TicketFactory.createAllTickets(rawTickets);
        Optional<Ticket> invalidTicket = ticketList.stream().filter(ticket -> !ticket.isValid()).findAny();
        if (invalidTicket.isPresent()){
            throw new InvalidTicketException(invalidTicket.get());
        }
        List<Ticket> sortedTickets = TicketSorter.sortTickets(ticketList);
        String output = TicketPrinter.printTickets(sortedTickets);
        System.out.println(output);
        return output.replace("\n","<br>");

    }

    public static void createAndPrintItinerary(String filePath) throws IOException, InvalidTicketException, UnknownTicketTypeException {

        String json = TicketFileInput.getJsonFromPath(filePath);
        printItineraryFromJson(json);
    }


}
