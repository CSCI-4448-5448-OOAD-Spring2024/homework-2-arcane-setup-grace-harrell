package arcane;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    @Test
    public void testName() { // tests that the character class property gets and sets name
        String test = "test name";
        Character character = new Character();
        character.setName(test);
        String testResult = character.getName();
        assert testResult.equals(test);
        character.setName("new_name");
        assert character.getName().equals("new_name");
    }

    @Test
    public void testDecreaseHealth(){
        Character character = new Character();
        assert character.getHealth() == 5;
        character.decreaseHealth();
        assert character.getHealth() == 4;
    }
}
