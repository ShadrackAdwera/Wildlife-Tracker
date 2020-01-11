import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

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


}

