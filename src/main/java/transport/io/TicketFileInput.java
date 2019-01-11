package transport.io;

import java.io.IOException;
import java.nio.file.*;

public class TicketFileInput {

    public static String getJsonFromPath(String filePath) throws IOException{
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
