package cs101.dz13;

import Exceptions.EmptyFieldException;
import Exceptions.JmbgException;

public class Main {

    public static void main(String[] args) {
        Zaposleni z1 = new Zaposleni();

        try {
            z1.ucitajZaposlenog();
            z1.proveraJmbga(z1.getJmbg());
            z1.prazanTekst();
        } catch (JmbgException ex) {
            System.err.println(ex.getMessage());
            System.exit(0);
        } catch (EmptyFieldException ex) {
            System.err.println(ex.getMessage());
            System.exit(0);
        } finally {
            z1.prikaziZaposlenog();
        }
        
    }

}
