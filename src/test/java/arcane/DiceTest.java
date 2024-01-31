package arcane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    @Test
    public void testRollingDie1(){
        Dice dice = new Dice();
        for (int i = 0; i < 50; i++) {
            int roll_value = dice.rollDie();
            assert (roll_value >= 1 && roll_value <= 6);
        }
    }
}