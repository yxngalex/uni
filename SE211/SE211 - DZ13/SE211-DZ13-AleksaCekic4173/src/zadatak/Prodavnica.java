package zadatak;

import java.util.*;

public class Prodavnica {

    private String naziv;
    private String lokacija;
    public List<Proizvod> proizvod;

    public Prodavnica() {
    }

    public Prodavnica(String naziv, String lokacija, List<Proizvod> proizvod) {
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.proizvod = proizvod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public List<Proizvod> getProizvod() {
        return proizvod;
    }

    public void setProizvod(List<Proizvod> proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public String toString() {
        return "Prodavnica{" + "naziv=" + naziv + ", lokacija=" + lokacija + ", proizvod=" + proizvod + '}';
    }

}
