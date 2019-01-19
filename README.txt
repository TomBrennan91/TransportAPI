I made this API for a job application:


This Transport API takes an unordered set of tickets as JSON as input, and it outputs a nicely formatted Itinerary to STDout.

HOW TO RUN IT:
 1. I will be hosting this app for a limited time as a service on AWS with a JavaScript Front end .
    PLEASE VISIT: transportapi.s3-website.us-east-2.amazonaws.com

 2. The API can be called via the Main(String args[]) method in the Application class. just pass in a filepath to your .json input file.
    If no arguments are passed in, an example input in ./src/main/resources/exampleTickets.json will be used as input.


KEY FEATURES:
- Easily Extensible: If a new means of transportation comes along, simply make a new class that extends the Ticket Class.
  for example-   Class HyperLoopTicket extends Ticket{}   Any extra information that is specific to this new mode of
  transport can then be added by overriding the constructor, and presented by overriding getItinerarySectionDescription().
  Because we use JSON as our input, none of the input data or any of the other ticket classes need to be modified.
  isValid() can also be overridden if there are new criteria which would cause the new type of boarding pass to be invalid.

- Sorting Algorithm. Using the magic of HashMaps this problem has been solved with Processing O(n) and Memory O(n).
  The usual Divide and conquer sorting algorithms don't work in this context because boarding passes cannot be ordered
  unless they are consecutive, so splitting the tickets into smaller pools is counter productive.
  However since each ticket has effectively a pointer to the next one, it turns out better performance is possible.

- Unit and integration Tests. This app has been Test-Driven-Developed and has Unit and Integration Tests.

- Home-brew Json Parser: I decided to use JSON as an input format as it is the most realistic real world input for a web-app.
  Since the assignment banned the use of all 3rd party libraries except for in the tests, I had to write my own parser.
  Obviously any sane developer would use Jackson or Gson here under usual circumstances.

- Ticket Validation. To catch bugs to do with missing mandatory boarding pass parameters in an extensible way. The Ticket
  class includes an IsValid() method which can be overridden.

- Error Handling: For tickets of unknown type, bad file paths, Missing mandatory ticket parameters, a helpful error
  message will be displayed in place of an itinerary.

ASSUMPTIONS:

- no loops in journeys: ie a trip cannot go like:  Birmingham -> Lichfield -> Sheffield -> Birmingham -> London
  because there is no way to tell which of the outbound trips from Birmingham comes first.

- input JSON only goes one layer deep. Obviously this is unrealistic in a real world scenario but in the real world
  I would be allowed to use Jackson, and I don't think writing a JSON parser was supposed to be part of the assignment!

- Inputs are case sensitive

- If there is a break in the chain of journeys, only the part of the itinerary containing the first journey in the input
  Json will be presented.

Example input:
[
  {
    "source":"Barcelona",
    "destination":"Gerona Airport",
    "type":"Airport Bus"
  },
  {
    "source":"Stockholm",
    "destination":"New York JFK",
    "type":"Flight",
    "seat":"7B",
    "vehicleName":"SK22",
    "boardingGate":"22"
  },
  {
    "source":"Madrid",
    "destination":"Barcelona",
    "type":"Train",
    "seat":"45B",
    "vehicleName":"78A"
  },
  {
    "source":"Gerona Airport",
    "destination":"Stockholm",
    "type":"Flight",
    "seat":"3A",
    "vehicleName":"SK455",
    "boardingGate":"45B",
    "baggageDropCounter":"344"
  }
]

Example Output:

1. Take the Train 78A from Madrid to Barcelona. Sit in seat 45B.
2. Take the Airport Bus from Barcelona to Gerona Airport. No seat assignment.
3. Take the Flight SK455 from Gerona Airport to Stockholm. Sit in seat 3A. Gate 45B. Baggage drop at ticket counter 344.
4. Take the Flight SK22 from Stockholm to New York JFK. Sit in seat 7B. Gate 22. Baggage will be automatically transferred from your last leg.
5. You have arrived at your destination.
