package cs101.dz08.zadatak3;

import java.util.ArrayList;
import java.util.List;

public class Kupovina {

    private List<Proizvod> listaProizvoda = new ArrayList<>();
    private int ukupnaCena;

    public Kupovina() {
    }

    public Kupovina(List<Proizvod> listaProizvoda, int ukupnaCena) {
        this.listaProizvoda = listaProizvoda;
        this.ukupnaCena = ukupnaCena;
    }

    public List<Proizvod> getListaProizvoda() {
        return listaProizvoda;
    }

    public void setListaProizvoda(List<Proizvod> listaProizvoda) {
        this.listaProizvoda = listaProizvoda;
    }

    public int getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(int ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    @Override
    public String toString() {
        return "Kupovina{" + "listaProizvoda=" + listaProizvoda + ", ukupnaCena=" + ukupnaCena + '}';
    }

    public int ukupnaCena() {
        int result = 0;
        for (Proizvod temp : listaProizvoda) {
            result += temp.getCena();
        }
        return result;
    }

    public void dodajUKorpu(Proizvod p) {
        this.listaProizvoda.add(p);
    }

    public Proizvod najskupljiProizvod() {
        Proizvod maks = this.listaProizvoda.get(0);
        for (int i = 0; i < this.listaProizvoda.size(); i++) {
            if (this.listaProizvoda.get(i).getCena() > maks.getCena()) {
                maks = this.listaProizvoda.get(i);
            }
        }
        return maks;
    }
 
}
