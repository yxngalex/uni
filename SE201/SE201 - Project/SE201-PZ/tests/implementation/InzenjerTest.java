package implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InzenjerTest {

    @Test
    void sacuvaj() {
        System.out.println("Provera cuvanje inzenjera!");
        String unos = "Uspesno ste sacuvali inzenjera!";
        Inzenjer inzenjerTemp = new Inzenjer();
        String result = inzenjerTemp.sacuvaj();
        assertEquals(unos, result);
    }
}