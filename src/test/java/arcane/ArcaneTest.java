package arcane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArcaneTest {
    @Test
    public void testPlay(){
        Arcane arcane = new Arcane();
        arcane.play();
        assertTrue(arcane.gameOver());
    }
}
