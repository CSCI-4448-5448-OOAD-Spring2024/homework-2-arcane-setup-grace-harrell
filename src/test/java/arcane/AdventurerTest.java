package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AdventurerTest {
    @Test
    public void testAdventurerName() {

        // gives an input string to the System
        String testName = "Test Name";
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);

        // creates a new adventurer
        Adventurer adventurer = new Adventurer();
        System.out.println("\nHello " + adventurer.getName());
        assert adventurer.getName().equals("Test Name");

    }

}