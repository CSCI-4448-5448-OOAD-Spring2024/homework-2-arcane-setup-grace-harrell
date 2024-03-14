package arcane.stepdefs

import arcane.*
import io.cucumber.java.en.*

class AdventurerStepDefs {
    Adventurer adventurer

    @Given("an Adventurer with a health of {int}")
    void createAdventurer(Integer health){
        adventurer = new Adventurer()
    }
    @When("I add {int} to the health")
    void adventurerGainsHealth(Integer healthGain){
        adventurer.decreaseHealth(-1*healthGain)
    }
    @When("the Adventurer loses {int} health points")
    void adventurerLosesHealth(Integer healthLoss){
        adventurer.decreaseHealth(healthLoss)
    }
    @Then("the Adventurer is still alive")
    void theAdventurerIsStillAlive(){
        assert adventurer.isAlive()
    }
    @Then("the Adventurer is dead")
    void theAdventurerIsDead() {
        assert !adventurer.isAlive();
    }
}