package simplejson;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class NaiveJsonParserTest {

    @Test
    public void TestNaiveJsonParserSingleTicket(){

        ArrayList<HashMap<String, String>> tickets =  NaiveJsonParser.getTicketsFromJson("[\n" +
                "  {\n" +
                "    \"source\":\"Barcelona\",\n" +
                "    \"destination\":\"Gerona Airport\",\n" +
                "    \"type\":\"Airport Bus\"\n" +
                "  },\n" +
                "  {\n" +
                "  }\n" +
                "]");

        assertEquals("Barcelona", tickets.get(0).get("source"));
        assertEquals("Gerona Airport", tickets.get(0).get("destination"));
        assertEquals("Airport Bus", tickets.get(0).get("type"));
        assertEquals(null, tickets.get(0).get("foo"));
    }

    @Test
    public void TestNaiveJsonParserMultiTicket(){

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

        assertEquals("Barcelona", tickets.get(0).get("source"));
        assertEquals("Gerona Airport", tickets.get(0).get("destination"));
        assertEquals("Airport Bus", tickets.get(0).get("type"));

        assertEquals("Barcelona", tickets.get(1).get("source"));
        assertEquals("Gerona Airport", tickets.get(1).get("destination"));
        assertEquals("Airport Bus", tickets.get(1).get("type"));
        assertEquals(null, tickets.get(1).get("foo"));
    }


}