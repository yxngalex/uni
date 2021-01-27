package cs101.dz08.zadatak3;

public class Proizvod {
    private String ime;
    private int cena;

    public Proizvod() {
    }

    public Proizvod(String ime, int cena) {
        this.ime = ime;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Proizvod{" + "ime=" + ime + ", cena=" + cena + '}';
    }
    
    
}
