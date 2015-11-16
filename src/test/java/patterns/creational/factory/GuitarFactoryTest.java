package patterns.creational.factory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GuitarFactoryTest {

    @Test
    public void testConstructGuitar() throws Exception {
        Guitar electricGuitar = GuitarFactory.constructGuitar(GuitarType.ELECTRIC);
        Guitar acousticGuitar = GuitarFactory.constructGuitar(GuitarType.ACOUSTIC);

        assertTrue(electricGuitar instanceof ElectricGuitar);
        assertTrue(acousticGuitar instanceof AcousticGuitar);
    }
}