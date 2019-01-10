package transport.scheduler;

import simplejson.NaiveJsonParser;
import transport.tickets.Ticket;
import transport.tickets.TicketFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> tickets =  NaiveJsonParser.getTicketsFromJson(
                "[\n" +
                        "  {\n" +
                        "    \"source\":\"Barcelona\",\n" +
                        "    \"destination\":\"Gerona Airport\",\n" +
                        "    \"type\":\"Airport Bus\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"source\":\"Madrid\",\n" +
                        "    \"destination\":\"Barcelona\",\n" +
                        "    \"type\":\"Train\",\n" +
                        "    \"seat\":\"45B\",\n" +
                        "    \"vehicleName\":\"78A\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"source\":\"Gerona Airport\",\n" +
                        "    \"destination\":\"Stockholm\",\n" +
                        "    \"type\":\"Flight\",\n" +
                        "    \"seat\":\"3A\",\n" +
                        "    \"vehicleName\":\"SK455\",\n" +
                        "    \"boardingGate\":\"45B\",\n" +
                        "    \"baggageDropCounter\":\"344\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"source\":\"Stockholm\",\n" +
                        "    \"destination\":\"New York JFK\",\n" +
                        "    \"type\":\"Flight\",\n" +
                        "    \"seat\":\"7B\",\n" +
                        "    \"vehicleName\":\"SK22\",\n" +
                        "    \"boardingGate\":\"22\"\n" +
                        "  }\n" +
                        "]");


        ArrayList<Ticket> ticketList =  TicketFactory.createAllTickets(tickets);

        int ticketNo = 0;
        for (Ticket ticket : ticketList){
            System.out.println(++ticketNo + ". " + ticket.getItinerarySectionDescription());
        }

        System.out.println(++ticketNo + ". You have arrived at your destination.");
        //ticketList.forEach(ticket -> ));

    }
}
