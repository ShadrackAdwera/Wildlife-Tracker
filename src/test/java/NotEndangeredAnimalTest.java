import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotEndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void equals_returnsBothInstancesOfObject_true() {
        NotEndangeredAnimal notEndangeredAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        NotEndangeredAnimal NotEndangeredAnimalTwo = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        assertEquals(notEndangeredAnimal, NotEndangeredAnimalTwo);
    }
    @Test
    public void getName_savesAnimalNameCorrectly_String() {
        NotEndangeredAnimal notEndangeredAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        assertEquals("Koala", notEndangeredAnimal.getName());
    }

    @Test
    public void getLocation_savesLocation(){
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "young", "upper quad","okay", 1);
        assertEquals("upper quad", testAnimal.getAnimalLocation());
    }

    @Test
    public void getHealthIll_savesHealthStatusAsIll_String() {
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant","ill", 1);
        assertEquals("ill", NotEndangeredAnimal.getHealthIll());

    }

    @Test
    public void getHealthOkay_savesHealthStatusAsOkay_String() {
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        assertEquals("okay", NotEndangeredAnimal.getHealthOkay());
    }

    @Test
    public void getAgeYoung_savesAgeAsYoung_String() {
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        assertEquals("young", NotEndangeredAnimal.getAgeYoung());
    }

    @Test
    public void getAgeNewborn_savesAgeAsNewBorn_String() {
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "newborn", "upper quadrant","okay", 1);
        assertEquals("newborn",NotEndangeredAnimal.getAgeNewborn());
    }

    @Test
    public void getAgeAdult_savesAgeAsAdult_String() {
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "adult", "upper quadrant","okay", 1);
        assertEquals("adult", NotEndangeredAnimal.getAgeAdult());
    }

    @Test
    public void getHealthStatus_savesHealthStatus() {
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant",Animal.getHealthHealthy(), 1);
        assertEquals(testAnimal.getHealthStatus(), NotEndangeredAnimal.getHealthHealthy());
    }


    @Test
    public void save_entrySavesSuccessfullyToDatabase(){
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        testAnimal.save();
        assertEquals(NotEndangeredAnimal.all().get(0), testAnimal);
    }
    @Test
    public void find_ReturnAnimalBasedOnId(){
        NotEndangeredAnimal testAnimal = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        NotEndangeredAnimal testAnimalTwo = new NotEndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        testAnimal.save();
        testAnimalTwo.save();
        assertEquals(NotEndangeredAnimal.find(testAnimalTwo.getId()), testAnimalTwo);
    }
    @Test
    public void assignLocationToAnimal(){
        Sighting sighting = new Sighting("lower quad", "adult");
        sighting.save();
        NotEndangeredAnimal animal = new NotEndangeredAnimal("deez nuts","young",sighting.getLocation(),"healthy",1);
        animal.save();
        NotEndangeredAnimal foundAnimal = NotEndangeredAnimal.find(animal.getId());
        assertEquals(foundAnimal.getAnimalLocation(), sighting.getLocation());
    }

}
