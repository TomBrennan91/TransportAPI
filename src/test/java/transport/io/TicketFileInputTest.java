package transport.io;

import org.junit.Test;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketFileInputTest {

    @Test
    public void validFilePath() throws IOException {
        assertEquals("[\r\n" +
                "  {\r\n" +
                "    \"source\":\"Barcelona\",\r\n" +
                "    \"destination\":\"Gerona Airport\",\r\n" +
                "    \"type\":\"Airport Bus\"\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"source\":\"Madrid\",\r\n" +
                "    \"destination\":\"Barcelona\",\r\n" +
                "    \"type\":\"Train\",\r\n" +
                "    \"seat\":\"45B\",\r\n" +
                "    \"vehicleName\":\"78A\"\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"source\":\"Gerona Airport\",\r\n" +
                "    \"destination\":\"Stockholm\",\r\n" +
                "    \"type\":\"Flight\",\r\n" +
                "    \"seat\":\"3A\",\r\n" +
                "    \"vehicleName\":\"SK455\",\r\n" +
                "    \"boardingGate\":\"45B\",\r\n" +
                "    \"baggageDropCounter\":\"344\"\r\n" +
                "  },\r\n" +
                "  {\r\n" +
                "    \"source\":\"Stockholm\",\r\n" +
                "    \"destination\":\"New York JFK\",\r\n" +
                "    \"type\":\"Flight\",\r\n" +
                "    \"seat\":\"7B\",\r\n" +
                "    \"vehicleName\":\"SK22\",\r\n" +
                "    \"boardingGate\":\"22\"\r\n" +
                "  }\r\n" +
                "]",TicketFileInput.getJsonFromPath("./src/main/resources/exampleTickets.json"));
    }

    @Test
    public void invalidFilePath(){
        assertThrows(NoSuchFileException.class, () ->TicketFileInput.getJsonFromPath("./badpath"));
    }

}