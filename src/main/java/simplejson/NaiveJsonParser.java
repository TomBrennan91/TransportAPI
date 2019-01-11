package simplejson;

import java.util.ArrayList;
import java.util.HashMap;

public class NaiveJsonParser {

    public static ArrayList<HashMap<String,String>> getTicketsFromJson(String input){

        if (input == null) return null;
        ArrayList<HashMap<String, String>> tickets = new ArrayList<>();

        input = input.replaceAll("\\n","")
                     .replace("[","")
                     .replace("]","");

        String[] rawTickets = input.split("}");

        for (String rawTicket: rawTickets){
            rawTicket = rawTicket.replace("{","").trim();
            if (rawTicket.startsWith(",")){
                rawTicket = rawTicket.replaceFirst(",","").trim();
            }

            HashMap<String, String> newTicket = getSingleTicketFromJSON(rawTicket);
            if (newTicket.size() > 0) {
                tickets.add(newTicket);
            }
        }

        //System.out.println(tickets.size() + " tickets");
        return tickets;
    }

    private static HashMap<String, String> getSingleTicketFromJSON(String input){
        HashMap<String ,String> ticket = new HashMap<>();

        for (int i = 0; i < 100 ; i++) {
            String[] splitInput = input.split(":", 2);
            String key = splitInput[0].replace("\"", "");

            if (splitInput.length < 2) return ticket;
            input = splitInput[1].trim();

            splitInput = input.split(",", 2);
            String value = splitInput[0].replace("\"", "");

            //System.out.println("key=" + key  + " , value=" + value);
            ticket.put(key,value);

            if (splitInput.length < 2) return  ticket;
            input = splitInput[1].trim();
        }
        return ticket;
    }

}
