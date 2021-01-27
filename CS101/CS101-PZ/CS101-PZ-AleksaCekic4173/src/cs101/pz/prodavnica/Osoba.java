package cs101.pz.prodavnica;

public abstract class Osoba {

    private String ime;
    private String prezime;
    private String jmbg;

    protected Osoba() {
    }

    protected Osoba(String ime, String prezime, String jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
    }

    public abstract void ucitajOsobu();

    public abstract void prikaziOsobu();

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return "Osoba{" + "ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + '}';
    }
}
