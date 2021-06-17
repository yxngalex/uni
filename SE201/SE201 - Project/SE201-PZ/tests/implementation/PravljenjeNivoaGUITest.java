package implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PravljenjeNivoaGUITest {

    @Test
    void prikaziGui() {
        System.out.println("Prikaz pravljenje nivoa GUI");
        String unos = "Gui se sada prikazuje";
        PravljenjeNivoaGUI pravljenjeNivoaTemp = new PravljenjeNivoaGUI();
        String result = pravljenjeNivoaTemp.prikaziGui();
        assertEquals(unos, result);
    }
}