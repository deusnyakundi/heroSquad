package ke.co.safaricom;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquadTest {
    @Test
    public void newSquad_instantiatesCorrectly_true() {
        Squad newSquad = Squad.setUpNewSquad();
        assertTrue(newSquad instanceof Squad);
    }
    @Test
    public void newSquad_getName_String() {
        Squad newSquad = Squad.setUpNewSquad();
        assertEquals("Avengers",newSquad.getSquadName());
    }
    @Test
    public void newSquad_getSize_Int() {
        Squad newSquad = Squad.setUpNewSquad();
        assertEquals(15,newSquad.getSize());
    }
    @Test
    public void newSquad_getPower_String() {
        Squad newSquad = Squad.setUpNewSquad();
        assertEquals("Infinity Stone",newSquad.getCause());
    }
    @Test
    public void newSquad_getInstances_true() {
        Squad newSquad = Squad.setUpNewSquad();
        Squad another = Squad.setUpNewSquad();
        assertTrue(Squad.getInstances().contains(newSquad));
        assertTrue(Squad.getInstances().contains(another));
    }
}
