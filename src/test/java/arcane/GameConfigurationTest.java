package arcane;

import org.junit.jupiter.api.Test;

public class GameConfigurationTest {
    @Test
    void testParsingArgumentsAndRunningGame() {
        String[] args = new String[]{
                "--numberOfRooms", "4",
                "--numberOfAdventurers", "2",
                "--numberOfCreatures", "2",
                "--numberOfFoodItems", "2"
        };
        GameConfiguration.main(args);
    }

}
