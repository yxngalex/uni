package implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemTest {

    @Test
    void prikazGui() {
        System.out.println("Provera prikazivanja GUI!");
        String unos = "Gui se sada prikazuje";
        Sistem sis = Sistem.getSistem();
        String result = sis.prikazGui();
        assertEquals(unos, result);
    }
}