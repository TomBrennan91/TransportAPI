package transport.scheduler;

import simplejson.NaiveJsonParser;
import transport.tickets.Ticket;
import transport.tickets.TicketFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> tickets =  NaiveJsonParser.getTicketsFromJson("[\n" +
                "  {\n" +
                "    \"source\":\"Barcelona\",\n" +
                "    \"destination\":\"Gerona Airport\",\n" +
                "    \"type\":\"Airport Bus\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"source\":\"Barcelona\",\n" +
                "    \"destination\":\"Gerona Airport\",\n" +
                "    \"type\":\"Airport Bus\"\n" +
                "  }" +
                "]");


        ArrayList<Ticket> ticketList =  TicketFactory.createAllTickets(tickets);


        for (Ticket ticket : ticketList){
            System.out.println(ticket.getItinerarySectionDescription());
        }
        //ticketList.forEach(ticket -> ));

    }
}
