import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Test
    public void testEquals_savesBothInstancesAsTrue() {
        Sighting sighting = new Sighting("koala", 1, "Upper Quadrants", "Deez Nuts");
        Sighting sightingTwo = new Sighting("koala", 1, "Upper Quadrants", "Deez Nuts");
        assertEquals(sighting, sightingTwo);
    }

    @Test
    public void getLocation_savesLocationSuccessfully_String() {
        Sighting sighting = new Sighting("koala", 1, "Upper Quadrants", "Deez Nuts");
        assertEquals("Upper Quadrants", sighting.getLocation());
    }

    @Test
    public void getRangerName_savesRangerNameSuccessfully() {
        Sighting sighting = new Sighting("koala", 1, "Upper Quadrants", "Deez Nuts");
        assertEquals("Deez Nuts", sighting.getRangerName());
    }
}
