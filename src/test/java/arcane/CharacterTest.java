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
        character.decreaseHealth(1);
        assert character.getHealth() == 4;
        character.decreaseHealth(1);
        assert character.getHealth() == 3;
    }

    @Test
    public void checkIsAlive(){
        Character character = new Character();
        assert character.isAlive();
        assert character.getHealth() == 5;
        character.decreaseHealth(1);
        assert character.getHealth() == 4;
        while (character.getHealth() > 0){
            character.decreaseHealth(1);
        }
        assert !character.isAlive();
    }
    @Test
    public void setAndTestIsAlive(){
        Character character = new Character();
        assert character.isAlive();
        character.setIsAlive(false);
        assert !character.isAlive();
        character.setIsAlive(true);
        assert character.isAlive();
    }
}
