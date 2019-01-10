package simplejson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NaiveJsonParser {

    public static ArrayList<HashMap<String,String>> getTicketsFromJson(String input){
        System.out.println(input);
        if (input == null) return null;
        ArrayList<HashMap<String, String>> tickets = new ArrayList<HashMap<String, String>>();
        System.out.println(input);
        input.replace("\\n","");
        input.replace("[","");
        input.replace("]","");
        String[] rawTickets = input.split("}");

        for (String rawTicket: rawTickets){
            System.out.println(rawTicket);
            getTicketsFromJson(rawTicket);
        }

        return tickets;
    }

    private static HashMap<String, String> getSingleTicketFromJSON(String input){
        HashMap<String ,String> ticket = new HashMap<String, String>();
        System.out.println(input);
        for (int i = 0; i < 100 ; i++) {

            String[] splitInput = input.split("\":\"", 1);
            if (splitInput.length < 2) {
                return ticket;
            }
            String key = splitInput[0].replace("\"", "");

            splitInput = input.split("\",\"", 1);
            if (splitInput.length < 2) {
                return ticket;
            }

            String value = splitInput[0].replace("\"", "");
            ticket.put(key,value);
            System.out.println(key + ":" + value);
        }

        return ticket;
    }

}
