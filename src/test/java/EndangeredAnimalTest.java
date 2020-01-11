import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void equals_returnsBothInstancesOfObject_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        EndangeredAnimal endangeredAnimalTwo = new EndangeredAnimal("Koala", "young", "upper quadrant","okay", 1);
        assertEquals(endangeredAnimal, endangeredAnimalTwo);
    }
    @Test
    public void getName_savesAnimalNameCorrectly_String() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        assertEquals("abc", testAnimal.getName());
    }
    @Test
    public void getHealthIll_savesHealthStatusAsIll_String() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        assertEquals("ill", EndangeredAnimal.getHealthIll());

    }

    @Test
    public void getHealthOkay_savesHealthStatusAsOkay_String() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        assertEquals("okay", EndangeredAnimal.getHealthOkay());
    }

    @Test
    public void getAgeYoung_savesAgeAsYoung_String() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        assertEquals("young", EndangeredAnimal.getAgeYoung());
    }

    @Test
    public void getAgeNewborn_savesAgeAsNewBorn_String() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        assertEquals("newborn",EndangeredAnimal.getAgeNewborn());
    }

    @Test
    public void getAgeAdult_savesAgeAsAdult_String() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        assertEquals("adult", EndangeredAnimal.getAgeAdult());
    }

    @Test
    public void setHealthStatus_changesHealthStatus() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        animal.setHealthStatus(EndangeredAnimal.getHealthOkay());
        assertEquals("okay", EndangeredAnimal.getHealthOkay());
    }

    @Test
    public void getHealthStatus_savesHealthStatus() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","healthy", 1);
        assertEquals(animal.getHealthStatus(), EndangeredAnimal.getHealthHealthy());
    }


    @Test
    public void setAge_changesAge() {
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        animal.setAge(EndangeredAnimal.getAgeYoung());
        assertEquals("young", EndangeredAnimal.getAgeYoung());
    }

    @Test
    public void save_entrySavesSuccessfullyToDatabase(){
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        animal.save();
        assertEquals(EndangeredAnimal.all().get(0), animal);
    }
    @Test
    public void find_ReturnAnimalBasedOnId(){
        EndangeredAnimal animal = new EndangeredAnimal("abc", "young","upper quad","okay", 1);
        EndangeredAnimal animalTwo = new EndangeredAnimal("def", "old","NE Wing","okay", 1);
        animal.save();
        animalTwo.save();
        assertEquals(EndangeredAnimal.find(animalTwo.getId()), animalTwo);
    }
    @Test
    public void assignLocationToAnimal(){
        Sighting sighting = new Sighting("lower quad", "adult");
        sighting.save();
        EndangeredAnimal animal = new EndangeredAnimal("deez nuts","youug","lower quad","healthy",1);
        animal.save();
        EndangeredAnimal foundAnimal = EndangeredAnimal.find(animal.getId());
        assertEquals(foundAnimal.getLocation(), sighting.getLocation());
    }


}

