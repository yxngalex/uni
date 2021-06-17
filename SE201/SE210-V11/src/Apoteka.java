import java.util.ArrayList;
import java.util.List;

public class Apoteka {
    private static String naziv;
    private static final List<Magacin> listaMagacina = new ArrayList<>(2);
    private static Apoteka apoteka;

    private String getNaziv() {
        return naziv;
    }

    public static Apoteka getApoteka() {
        return apoteka;
    }

    private Apoteka() {
        apoteka = new Apoteka();
        setNaziv("Benu");
        Magacin prviMagacin = new Magacin(1);
        Magacin drugiMagacin = new Magacin(2);
        listaMagacina.add(prviMagacin);
        listaMagacina.add(drugiMagacin);
    }

    private static void setNaziv(String naziv) {
        Apoteka.naziv = naziv;
    }

    private static List<Magacin> getListaMagacina() {
        return listaMagacina;
    }
}
