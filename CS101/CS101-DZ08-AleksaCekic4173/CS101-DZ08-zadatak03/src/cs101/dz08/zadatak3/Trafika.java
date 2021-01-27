package cs101.dz08.zadatak3;

import java.util.ArrayList;
import java.util.List;

public class Trafika {

    private String ime;
    private String adresa;
    private List<Proizvod> listaProizvoda = new ArrayList<>();
    private List<Kupovina> listaKupovina = new ArrayList<>();

    public Trafika() {
    }

    public Trafika(String ime, String adresa) {
        this.ime = ime;
        this.adresa = adresa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Proizvod> getListaProizvoda() {
        return listaProizvoda;
    }

    public void setListaProizvoda(List<Proizvod> listaProizvoda) {
        this.listaProizvoda = listaProizvoda;
    }

    public List<Kupovina> getListaKupovina() {
        return listaKupovina;
    }

    public void setListaKupovina(List<Kupovina> listaKupovina) {
        this.listaKupovina = listaKupovina;
    }

    @Override
    public String toString() {
        return "Trafika{" + "ime=" + ime + ", adresa=" + adresa + ", listaProizvoda=" + listaProizvoda + ", listaKupovina=" + listaKupovina + '}';
    }

    public double stanjeKase() {
        double sum = 0;
        for (int i = 0; i < listaKupovina.size(); i++) {
            sum += listaKupovina.get(i).ukupnaCena();
        }
        return sum;
    }

    public void dodajProizvod(Proizvod p) {
        listaProizvoda.add(p);
    }

    public void dodajKupovinu(Kupovina k) {
        listaKupovina.add(k);
    }

}
