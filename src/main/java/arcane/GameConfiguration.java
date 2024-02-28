package arcane;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;

public class GameConfiguration {
    public static void main(String[] args){
        CommandLineParser parser = new DefaultParser();
        // takes arguments in the following format....
//        "--numberOfRooms", "4",
//                "--numberOfAdventurers", "2",
//                "--numberOfCreatures", "2",
//                "--numberOfFoodItems", "2"

        // uses arguments to create new Factories...
        // i.e. AdventurerFactory af = new AdventurerFactory(numCreatures)
        // creates Cave ith Builder
    }
}
