package zadatak;


public class PrehrambreniProizvod extends Proizvod {

    public PrehrambreniProizvod(String naziv, double cena, String sifra) throws NevalidnaSifraException {
        super(naziv, cena, sifra);
    }

    public PrehrambreniProizvod() {
    }
    
}