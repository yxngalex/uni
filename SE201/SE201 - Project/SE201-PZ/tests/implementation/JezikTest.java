package implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JezikTest {

    @Test
    void sacuvaj() {
        System.out.println("Provera cuvanja jezika!");
        String unos = "Uspesno ste sacuvali jezik!";
        Jezik noviJezik = new Jezik();
        String result = noviJezik.sacuvaj();
        assertEquals(unos, result);
    }
}