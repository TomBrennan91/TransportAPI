package transport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void HappyPathIntegrationTest(){
        Application.main(null);
        assertEquals("1. Take the Train 78A from Madrid to Barcelona. Sit in seat 45B.\r\n" +
                              "2. Take the Airport Bus from Barcelona to Gerona Airport. No seat assignment.\r\n" +
                              "3. Take the Flight SK455 from Gerona Airport to Stockholm. Sit in seat 3A. Gate 45B. Baggage drop at ticket counter 344.\r\n" +
                              "4. Take the Flight SK22 from Stockholm to New York JFK. Sit in seat 7B. Gate 22. Baggage will be automatically transferred from your last leg.\r\n" +
                              "5. You have arrived at your destination.\r\n",outContent.toString());
    }

}