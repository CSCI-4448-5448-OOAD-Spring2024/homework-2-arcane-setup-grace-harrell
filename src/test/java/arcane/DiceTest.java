package arcane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    @Test
    public void testRollingDie1(){
        Dice dice = new Dice();
        int roll_value = dice.rollDie();
        assert(roll_value >= 1 && roll_value <= 6);
    }
    @Test
    public void testRollingDie2(){
        Dice dice = new Dice();
        int roll_value = dice.rollDie();
        assert(roll_value >= 1 && roll_value <= 6);
    }
    @Test
    public void testRollingDieFail(){
        Dice dice = new Dice();
        int roll_value = dice.rollDie();
        assertFalse(roll_value < 1 || roll_value > 6);
    }
}