package arcane;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcaneTest {
    public void provideInput(String testName) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(testName.getBytes());
        System.setIn(testInput);
    }
    @Test
    public void testPlay(){
        provideInput("Testy");
        Arcane arcane = new Arcane();
        arcane.play();
    }
}
