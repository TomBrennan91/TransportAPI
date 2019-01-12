package transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        String filePath;
//        if (args == null || args.length == 0){
//            filePath = "./src/main/resources/exampleTickets.json";
//        } else {
//            filePath = args[0];
//        }
//
//        try {
//            ItineraryController.createAndPrintItinerary(filePath);
//        } catch (InvalidTicketException | UnknownTicketTypeException| IOException e){
//            e.printStackTrace();
//        }

        SpringApplication.run(Application.class,args);

    }


}
