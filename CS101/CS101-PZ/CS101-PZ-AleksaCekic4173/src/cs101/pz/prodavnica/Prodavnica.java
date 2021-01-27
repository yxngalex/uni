package cs101.pz.prodavnica;

import java.time.DateTimeException;

public class Prodavnica implements Comparable {

    private String nazivProdavnice;
    private String adresa;
    private TipProdavnice tip;

    public Prodavnica(String nazivProdavnice, String adresa, TipProdavnice tip) {
        this.nazivProdavnice = nazivProdavnice;
        this.adresa = adresa;
        this.tip = tip;
    }

    public Prodavnica() {
    }

    public String getNazivProdavnice() {
        return nazivProdavnice;
    }

    public void setNazivProdavnice(String nazivProdavnice) {
        this.nazivProdavnice = nazivProdavnice;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public TipProdavnice getTip() {
        return tip;
    }

    public void setTip(TipProdavnice tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Prodavnica{" + "naziv=" + nazivProdavnice + ", adresa=" + adresa + ", tip=" + tip + '}';
    }

    public void radnoVreme(int hour) {
        if (hour >= 7 && hour <= 21) {
            System.out.println("Prodavnica radi!!!");
        } else {
            throw new DateTimeException("Prodavnica ne radi!!!");
        }
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

enum TipProdavnice {
    trafika, kiosk, market
}
