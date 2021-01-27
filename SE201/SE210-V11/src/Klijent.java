import java.util.ArrayList;
import java.util.List;

public class Klijent {
    private String ime;
    private String prezime;
    private String adresa;
    private Porudzbina porudzbina; // Lista porudzbina

    public Klijent() {
    }

    public Klijent(String ime, String prezime, String adresa, Porudzbina porudzbina) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.porudzbina = porudzbina;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Klijent{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", porudzbina=" + porudzbina +
                '}';
    }
}
