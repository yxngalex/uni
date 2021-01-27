package implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void exists() {
        System.out.println("Provera postojanja modela!");
        boolean provera = true;
        Model modelTemp = new Model();
        boolean result = modelTemp.exists();
        assertEquals(provera,result);
    }

    @Test
    void animiraj() {
        System.out.println("Provera animiranja modela");
        String unos = "Uspesno ste animirali!";
        Model modelTemp = new Model();
        String result = modelTemp.animiraj();
        assertEquals(unos, result);
    }
}