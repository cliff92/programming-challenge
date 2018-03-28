package de.exxcellent.challenge;

import de.exxcellent.reader.CSVReader;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        // Your preparation code …
    	CSVReader reader = new CSVReader();
    	String weatherFilePath = "src/main/resources/de/exxcellent/challenge/weather.csv";
    	Weather weather = new Weather(weatherFilePath, reader);

        String dayWithSmallestTempSpread = Integer.toString(weather.findDayWithSmallestTempSpread());     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
