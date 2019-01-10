package simplejson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaiveJsonParserTest {

    @Test
    private void TestNaiveJsonPArser(){
        NaiveJsonParser.getTicketsFromJson("[\n" +
                "  {\n" +
                "    \"source\":\"Barcelona\",\n" +
                "    \"destination\":\"Gerona Airport\",\n" +
                "    \"type\":\"Airport Bus\"\n" +
                "  },\n" +
                "  {\n" +
                "  }\n" +
                "]");

        assertFalse(false);
    }


}