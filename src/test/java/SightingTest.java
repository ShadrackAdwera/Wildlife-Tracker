import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Test
    public void testEquals_savesBothInstancesAsTrue() {
        Sighting sighting = new Sighting("koala", "adult", "healthy", "upper quad", "Deez Nuts");
        Sighting sightingTwo = new Sighting("koala", "adult", "healthy", "upper quad", "Deez Nuts");
        assertEquals(sighting, sightingTwo);
    }

    @Test
    public void getLocation_savesLocationSuccessfully_String() {
        Sighting sighting = new Sighting("koala", "adult", "healthy", "upper quad", "Deez Nuts");
        assertEquals("upper quad", sighting.getLocation());
    }

    @Test
    public void getRangerName_savesRangerNameSuccessfully() {
        Sighting sighting = new Sighting("koala", "adult", "healthy", "upper quad", "Deez Nuts");
        assertEquals("Deez Nuts", sighting.getRangerName());
    }
}

