import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void methodInstantiatesCorrectly(){
        Animal testAnimal = new Animal("abc",1);
        assertTrue(testAnimal instanceof Animal);
    }

    @Test
    public void equals_ReturnsBothInstancesSaved_true() {
        Animal testAnimal = new Animal("abc",1);
        Animal testAnimalTwo = new Animal("abc",1);
        assertEquals(testAnimal, testAnimalTwo);
    }

    @Test
    public void getId_savesAnimalIdCorrectly_int() {
        Animal testAnimal = new Animal("abc",1);
        assertEquals(1, testAnimal.getId());
    }

    @Test
    public void getName_savesAnimalNameCorrectly_String() {
        Animal testAnimal = new Animal("abc",1);
        assertEquals("abc", testAnimal.getName());
    }
}
