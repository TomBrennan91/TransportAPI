This Transport API takes an unordered set of tickets as JSON as input and Outputs a nicely formatted Itinerary to STDout.

The API can be called via the Main(String args[]) method, just pass in a filepath to your .json input file.

If no arguments are passed in, an example input in ./src/main/resources/exampleTickets.json will be used as input.

I will also be hosting this app for a limited time as a service on AWS with a nice JavaScript Front end . please go to :


Example input:



Example Output:


Key Features:
- Homebrew Json Parser. Since the assignment banned the use of all 3rd party libraries except for in the tests.
  Obviously any sane developer would use Jackson or Gson here under usual circumstances

- Error Handling.

- Unit and integration Tests.

- Sorting Algorithm.


Assumptions:

- no loops in journeys.

- input JSON only goes one layer deep: