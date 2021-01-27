package implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PisanjeFunkcionalnostiGUITest {

    @Test
    void sacuvajZapisanuFunkciju() {
        System.out.println("Provera cuvanja zapisane funkcije!");
        String unos = "Uspesno ste sacuvali zapisanu funkciju";
        PisanjeFunkcionalnostiGUI pisanjefunkcionalnosti = new PisanjeFunkcionalnostiGUI();
        String result = pisanjefunkcionalnosti.sacuvajZapisanuFunkciju();
        assertEquals(unos, result);
    }

    @Test
    void odabraoJezik() {
        System.out.println("Provera biranje jezika!");
        boolean odabrao = false;
        PisanjeFunkcionalnostiGUI pisanjefunkcionalnosti = new PisanjeFunkcionalnostiGUI();
        boolean result = pisanjefunkcionalnosti.odabraoJezik();
        assertEquals(odabrao, result);
    }

    @Test
    void biraJezik() {
        System.out.println("Biranje jezika test!");
        String unos = "Izaberite vas programski jezik";
        PisanjeFunkcionalnostiGUI pisanjefunkcionalnosti = new PisanjeFunkcionalnostiGUI();
        String result = pisanjefunkcionalnosti.biraJezik();
        assertEquals(unos, result);
    }
}