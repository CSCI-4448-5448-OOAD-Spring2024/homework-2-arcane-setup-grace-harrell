package arcane;

import org.junit.jupiter.api.Test;

public class EntityTest{
    @Test
    public void testName() { // tests that the character class property gets and sets name
        String test = "test name";
        Entity entity = new Entity();
        entity.setName(test);
        String testResult = entity.getName();
        assert testResult.equals(test);
        entity.setName("new_name");
        assert entity.getName().equals("new_name");
    }

    @Test
    public void testDecreaseHealth(){
        Entity entity = new Entity();
        assert entity.getHealth() == 5;
        entity.decreaseHealth(1);
        assert entity.getHealth() == 4;
        entity.decreaseHealth(1);
        assert entity.getHealth() == 3;
    }

    @Test
    public void checkIsAlive(){
        Entity entity = new Entity();
        assert entity.isAlive();
        assert entity.getHealth() == 5;
        entity.decreaseHealth(1);
        assert entity.getHealth() == 4;
        while (entity.getHealth() > 0){
            entity.decreaseHealth(1);
        }
        assert !entity.isAlive();
    }
    @Test
    public void setAndTestIsAlive(){
        Entity entity = new Entity();
        assert entity.isAlive();
        entity.setIsAlive(false);
        assert !entity.isAlive();
        entity.setIsAlive(true);
        assert entity.isAlive();
    }
}
