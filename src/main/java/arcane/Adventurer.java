package arcane;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Adventurer extends Entity{

    private static final Logger logger = Logger.getLogger(Adventurer.class.getName());

    public Adventurer(){
//        Scanner scan = new Scanner(System.in);
//        logger.info("Hello Adventurer! Please enter your name: ");
//        String newAdventurer = scan.nextLine();
        String [] adventurerNames = new String[15];
        adventurerNames[0] = "Ethan";
        adventurerNames[1] = "Olivia";
        adventurerNames[2] = "Liam";
        adventurerNames[3] = "Emma";
        adventurerNames[4] = "Jackson";
        adventurerNames[5] = "Sophia";
        adventurerNames[6] = "Aiden";
        adventurerNames[7] = "Ava";
        adventurerNames[8] = "Lucas";
        adventurerNames[9] = "Isabella";
        adventurerNames[10] = "Noah";
        adventurerNames[11] = "Benjamin";
        adventurerNames[12] = "Harper";
        adventurerNames[13] = "James";
        adventurerNames[14] = "Alex";


        // generates a random index for creatureTypes
        Random ran = new Random();
        int idx = ran.nextInt(14);
        setName(adventurerNames[idx]);
    }
}
