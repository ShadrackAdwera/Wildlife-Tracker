import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Test
    public void equals_returnsBothInstancesOfObject_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        EndangeredAnimal endangeredAnimalTwo = new EndangeredAnimal("Koala",1);
        assertEquals(endangeredAnimal, endangeredAnimalTwo);
    }

    @Test
    public void getHealthIll_savesHealthStatusAsIll_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        assertEquals("ill", EndangeredAnimal.getHealthIll());

    }

    @Test
    public void getHealthOkay_savesHealthStatusAsOkay_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        assertEquals("okay", EndangeredAnimal.getHealthOkay());
    }

    @Test
    public void getAgeYoung_savesAgeAsYoung_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        assertEquals("young", EndangeredAnimal.getAgeYoung());
    }

    @Test
    public void getAgeNewborn_savesAgeAsNewBorn_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        assertEquals("newborn",EndangeredAnimal.getAgeNewborn());
    }

    @Test
    public void getAgeAdult_savesAgeAsAdult_String() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        assertEquals("adult", EndangeredAnimal.getAgeAdult());
    }

    @Test
    public void setHealthStatus_changesHealthStatus() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        endangeredAnimal.setHealthStatus(EndangeredAnimal.getHealthOkay());
        assertEquals("okay", EndangeredAnimal.getHealthOkay());
    }

    @Test
    public void getHealthStatus_savesHealthStatus() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        assertEquals(endangeredAnimal.getHealthStatus(), EndangeredAnimal.getHealthHealthy());
    }

    @Test
    public void getAge_savesIdSuccessfully_int() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        assertEquals(1, endangeredAnimal.getId());
    }

    @Test
    public void setAge_changesAge() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("Koala",1);
        endangeredAnimal.setAge(EndangeredAnimal.getAgeYoung());
        assertEquals("young", EndangeredAnimal.getAgeYoung());
    }

}

