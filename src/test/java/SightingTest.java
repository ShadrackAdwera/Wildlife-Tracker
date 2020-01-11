import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void testEquals_savesBothInstancesAsTrue() {
        Sighting sighting = new Sighting("koala", "adult");
        Sighting sightingTwo = new Sighting("koala", "adult");
        assertEquals(sighting, sightingTwo);
    }

    @Test
    public void getLocation_savesLocationSuccessfully_String() {
        Sighting sighting = new Sighting("koala", "adult");
        assertEquals("koala", sighting.getLocation());
    }

    @Test
    public void getRangerName_savesRangerNameSuccessfully() {
        Sighting sighting = new Sighting("koala", "adult");
        assertEquals("adult", sighting.getRangerName());
    }
    @Test
    public void save_saveSightSuccessfully(){
        Sighting sighting = new Sighting("koala", "adult");
        sighting.save();
        Sighting sightingTwo = new Sighting("Kenya", "deez nuts");
        sightingTwo.save();
        assertEquals(Sighting.all().get(0), sighting);
    }
    @Test
    public void find_returnsSightById(){
        Sighting sightingTwo = new Sighting("Kenya", "deez nuts");
        sightingTwo.save();
        assertEquals(Sighting.find(sightingTwo.getId()), sightingTwo);
    }
    @Test
    public void all_returnsAllSightings(){
        Sighting sighting = new Sighting("koala", "adult");
        sighting.save();
        Sighting sightingTwo = new Sighting("Kenya", "deez nuts");
        sightingTwo.save();
        assertEquals(Sighting.all().get(0), sighting);
        assertEquals(Sighting.all().get(1), sightingTwo);

    }
    @Test
    public void getAnimals_retrievesAllAnimalsFromDatabase_animalList() {
        Sighting testSite = new Sighting("Upper quad", "deez nuts");
        testSite.save();
        EndangeredAnimal animal = new EndangeredAnimal("koala","young", testSite.getLocation(),"healthy",1);
        animal.save();
        EndangeredAnimal animalTwo = new EndangeredAnimal("koala","young", testSite.getLocation(),"ill",2);
        animalTwo.save();
        EndangeredAnimal[] endangeredAnimals = new EndangeredAnimal[] { animal, animalTwo };
        assertTrue(Sighting.findByLocation(testSite.getLocation()).containsAll(Arrays.asList(endangeredAnimals)));
    }
    @Test
    public void findByLocation_returnAllAnimalsInALocation(){
        Sighting testSite = new Sighting("Upper quad", "deez nuts");
        testSite.save();
        EndangeredAnimal animal = new EndangeredAnimal("koala","young", testSite.getLocation(),"healthy",1);
        animal.save();
        EndangeredAnimal animalTwo = new EndangeredAnimal("koala","young", testSite.getLocation(),"ill",2);
        animalTwo.save();
        assertEquals(2, Sighting.findByLocation(testSite.getLocation()).size());
    }

}


