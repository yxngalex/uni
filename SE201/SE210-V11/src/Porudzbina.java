import java.util.ArrayList;
import java.util.List;

// Dodavanje pojedinacnog leka u metodi

public class Porudzbina {
    private List<Lek> lekovi = new ArrayList<>();

    public Porudzbina() {
    }

    public Porudzbina(List<Lek> lekovi) {
        this.lekovi = lekovi;
    }

    public List<Lek> getLekovi() {
        return lekovi;
    }

    public void setLekovi(List<Lek> lekovi) {
        this.lekovi = lekovi;
    }

    public void naruci() {
        System.out.println("Naruceni lekovi: " + lekovi);
    }

    public void dodajLek(Lek lek) {
        lekovi.add(lek);
    }
}
