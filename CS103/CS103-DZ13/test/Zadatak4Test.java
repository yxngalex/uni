import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Zadatak4Test {

    @Test
    void isMatch() {
        System.out.println("Regularni izraz za google!");
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String text = "https://google.com";
        boolean matches = text.matches(regex);
        assertEquals(true, matches);
    }

    @Test
    void isMatch2() {
        System.out.println("Regularni izraz za metropolitan sajt!");
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String text = "https://www.metropolitan.ac.rs/";
        boolean matches = text.matches(regex);
        assertEquals(true, matches);
    }

    @Test
    void isMatch3() {
        System.out.println("Regularni izraz za geeks for geeks!");
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String text = "https://www.geeksforgeeks.org/";
        boolean matches = text.matches(regex);
        assertEquals(true, matches);
    }

    @Test
    void isMatch4() {
        System.out.println("Regularni izraz za isum!");
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String text = "https://isum.metropolitan.ac.rs/isum=1610200403276/";
        boolean matches = text.matches(regex);
        assertEquals(true, matches);
    }

    @Test
    void isMatch5() {
        System.out.println("Testiranje lose napisanog patterna za regularni izraz!");
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String text = "test://mail.metropolitan.ac.rs";
        boolean matches = text.matches(regex);
        assertEquals(false, matches);
    }

    @Test
    void isMatch6() {
        System.out.println("Testiranje jos jednog lose napisanog patterna za regularni izraz!");
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String text = "ftp:/tEsT.test";
        boolean matches = text.matches(regex);
        assertEquals(false, matches);
    }
}