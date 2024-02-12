package arcane;

import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.logging.Logger;

public class Adventurer extends Entity{

    private static final Logger logger = Logger.getLogger(String.valueOf(Adventurer.class));

    public Adventurer(){
        Scanner scan = new Scanner(System.in);
        logger.info("Hello Adventurer! Please enter your name: ");
        String newAdventurer = scan.nextLine();
        setName(newAdventurer);
    }
}
