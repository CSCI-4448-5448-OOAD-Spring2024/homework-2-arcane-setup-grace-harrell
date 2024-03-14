package arcane.stepdefs

import arcane.*
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory;

import java.util.*;

class ArcaneStepDefs {
    private static final Logger logger = LoggerFactory.getLogger("csci.ooad.arcane.Arcane");
    private Cave cave;
    private Arcane arcane;
    private MockObserver observer;
    private AudibleObserver audibleObserver;

    private int getIntValue(Map<String, String> attributes, String key) {
        String value = attributes.get(key);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.err.println("Failed to parse integer for attribute: " + key);
            }
        }
        return -1; // Return a sentinel value to indicate invalid or missing attribute
    }

    @Given("I have a game with the following attributes:")
    void createComplicatedGame(DataTable dataTable) {
        Map<String, String> attributes = dataTable.asMap(String.class, String.class);
        int numRooms = getIntValue(attributes, "number of rooms");
        int numAdventurers = getIntValue(attributes, "number of adventurers");
        int numKnights = getIntValue(attributes, "number of knights");
        int numCowards = getIntValue(attributes, "number of cowards");
        int numGluttons = getIntValue(attributes, "number of gluttons");
        int numCreatures = getIntValue(attributes, "number of creatures");
        int numDemons = getIntValue(attributes, "number of demons");
        int numFood = getIntValue(attributes, "number of food items");
        cave = new Cave.Builder().createFullyConnectedRooms(numRooms)
                .createAndAddAdventurers(numAdventurers)
                .createAndAddKnights(numKnights)
                .createAndAddCowards(numCowards)
                .createAndAddGluttons(numGluttons)
                .createAndAddCreatures(numCreatures)
                .createAndAddDemons(numDemons)
                .createAndAddFood(numFood)
                .build();

        Dice dice = createDice();
        observer = new MockObserver();
        audibleObserver = new AudibleObserver(5);

        arcane = new Arcane(cave, dice)
    }

    @When("I play the game")
    void playGame() {
        arcane.attachObservers(observer);
        arcane.attachAudibleObserver(audibleObserver, Arrays.asList(EventType.FightingOutcome, EventType.Death, EventType.GameOver));
        arcane.play();
    }

    @Then("I should be told that either all the adventurers or all of the creatures have died")
    void verifyGameOutcome() {
        assert(observer.getEventDescription().contains("Adventurers won!") || observer.getEventDescription().contains("Creatures won!"))
    }

    @And("the game should be over")
    void verifyGameOver() {
        assert(observer.getEventDescription().contains("The game is over"));
    }

    // Method to create a Dice object (you can implement this according to your actual implementation)
    private static Dice createDice() {
        return new Dice();
    }

}

