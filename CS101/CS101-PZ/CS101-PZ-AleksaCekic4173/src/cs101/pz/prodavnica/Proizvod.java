package cs101.pz.prodavnica;

public class Proizvod {

    private String ime;
    private double cena;
    private boolean dostupan;

    public Proizvod() {
    }

    public Proizvod(String ime, double cena, boolean dostupan) {
        this.ime = ime;
        this.cena = cena;
        this.dostupan = dostupan;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public boolean isDostupan() {
        return dostupan;
    }

    public void setDostupan(boolean dostupan) {
        this.dostupan = dostupan;
    }

    @Override
    public String toString() {
        return "Proizvod{" + "ime=" + ime + ", cena=" + cena + ", dostupan=" + dostupan + '}';
    }

}
