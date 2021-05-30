package zadatak;

public abstract class Proizvod {

    private String naziv;
    private double cena;
    private String sifra;

    public Proizvod() {
    }

    public Proizvod(String naziv, double cena, String sifra) throws NevalidnaSifraException {
        this.naziv = naziv;
        this.cena = cena;
        setSifra(sifra);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) throws NevalidnaSifraException {
        if (!sifra.matches("^[A-z0-9]{1,4}$")) {
           throw new NevalidnaSifraException("Sifra ne sme da sadrzi specijalne karaktere i vise od cetiri karaktera");
        } else {
            this.sifra = sifra;
        }
    }

    @Override
    public String toString() {
        return "Proizvod{" + "naziv=" + naziv + ", cena=" + cena + ", sifra=" + sifra + '}';
    }

}
