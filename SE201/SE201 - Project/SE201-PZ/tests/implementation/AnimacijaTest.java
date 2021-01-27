package implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimacijaTest {
    @Test
    void animiraj() {
        System.out.println("Provera animiranja!");
        String unos = "Uspesno ste animirali!";
        Animacija novaAnimacija = new Animacija();
        String result = novaAnimacija.animiraj();
        assertEquals(unos, result);
    }

    @Test
    void animirajModel() {
        System.out.println("Provera animiranja modela");
        String unos = "Model je uspesno animiran!";
        Animacija novaAnimacija = new Animacija();
        String result = novaAnimacija.animirajModel();
        assertEquals(unos, result);
    }
}