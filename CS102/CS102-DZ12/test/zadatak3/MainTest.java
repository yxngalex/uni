package zadatak3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBrojParnihCifara() {
        int n = 0;
        int expResult = 0;
        int result = Main.brojParnihCifara(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBrojParnihCifara2() {
        int n = -8;
        int expResult = 4;
        int result = Main.brojParnihCifara(n);
        assertEquals(expResult, result);
    }
    @Test
    public void testBrojParnihCifara3() {
        int n = -15;
        int expResult = 7;
        int result = Main.brojParnihCifara(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBrojParnihCifara4() {
        int n = 20;
        int expResult = 10;
        int result = Main.brojParnihCifara(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBrojParnihCifara5() {
        int n = 1;
        int expResult = 0;
        int result = Main.brojParnihCifara(n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBrojParnihCifara6() {
        int n = 2;
        int expResult = 0;
        int result = Main.brojParnihCifara(n);
        assertNotEquals(expResult, result);
    }
}
