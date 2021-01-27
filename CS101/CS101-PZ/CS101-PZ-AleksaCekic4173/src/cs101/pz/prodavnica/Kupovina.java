package cs101.pz.prodavnica;

import cs101.pz.prodavnica.exception.NemaDovoljnoNovcaException;
import java.util.ArrayList;
import java.util.List;

public class Kupovina {

    List<Proizvod> listaProizvoda = new ArrayList<>();
    private double Cena;

    public Kupovina(double Cena) {
        this.Cena = Cena;
    }

    public Kupovina() {
    }

    public List<Proizvod> getListaProizvoda() {
        return listaProizvoda;
    }

    public void setListaProizvoda(List<Proizvod> listaProizvoda) {
        this.listaProizvoda = listaProizvoda;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double Cena) {
        this.Cena = Cena;
    }

    public void dodajUkorpu(Proizvod p) {
        this.listaProizvoda.add(p);
    }

    @Override
    public String toString() {
        return "Kupovina{" + "listaProizvoda=" + listaProizvoda + ", Cena=" + Cena + '}';
    }

    public double ukupnaCena() {
        int result = 0;
        for (Proizvod temp : listaProizvoda) {
            result += temp.getCena();
        }
        return result;
    }

    public void daLiJePauza(Prodavac p) {
        if (p.isPauza()) {
            throw new RuntimeException("PRODAVAC JE NA PAUZI, VRATITE SE MALO KASNIJE!!!");
        } else {
            System.out.println("Prodavac nije na pauzi, mozete nastaviti sa kupovinom!");
        }
    }

    public void dostupanProizvod() {
        for (Proizvod temp : listaProizvoda) {
            if (temp.isDostupan()) {
                System.out.println("CENA PROIZVODA " + temp.getIme() + " , JE: " + temp.getCena());
            } else {
                throw new RuntimeException("KUPOVINA ZA NEKE OD PROIZVODA JE NEMOGUCA, IZBRISITE NEDOSTUPNE PROIZVODE SA SHOPPING LISTE!!!");
            }
        }
    }

    public double izvrsenjeKupovine(Kupac k) throws NemaDovoljnoNovcaException {
        double result = 0;
        for (Proizvod temp : listaProizvoda) {
            if (k.getNovac() >= temp.getCena()) {
                result = k.getNovac() - temp.getCena();
            } else {
                throw new NemaDovoljnoNovcaException();
            }
        }
        return result;
    }

}
