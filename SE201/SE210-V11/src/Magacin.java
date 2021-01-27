import java.util.ArrayList;
import java.util.List;

public class Magacin {
    private int brojMagacina;
    private List<Lek> lekoviUMagacinu = new ArrayList<Lek>();

    public Magacin() {
    }

    public Magacin(int brojMagacina) {
        this.brojMagacina = brojMagacina;
    }

    public int getBrojMagacina() {
        return brojMagacina;
    }

    public void setBrojMagacina(int brojMagacina) {
        this.brojMagacina = brojMagacina;
    }

    public List<Lek> getLekoviUMagacinu() {
        return lekoviUMagacinu;
    }

    public void setLekoviUMagacinu(List<Lek> lekoviUMagacinu) {
        this.lekoviUMagacinu = lekoviUMagacinu;
    }
}
