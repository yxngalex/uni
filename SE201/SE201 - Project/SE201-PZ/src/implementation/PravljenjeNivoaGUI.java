package implementation;

public class PravljenjeNivoaGUI {
    private String naziv;
    private String oblik;
    private String boja;
    private String dimenzije;

    public String getnaziv() {
        return naziv;
    }

    public void setnaziv(String newNaziv) {
        naziv = newNaziv;
    }

    public PravljenjeNivoaGUI() {
    }

    public String prikaziGui() {
        return "Gui se sada prikazuje";
    }

}