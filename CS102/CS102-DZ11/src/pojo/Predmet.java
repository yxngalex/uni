package pojo;

public class Predmet {

    private int id;
    private String sifra_predmeta;
    private String naziv_predmeta;
    private int id_profesora;


    public Predmet() {
    }

    public Predmet(String sifra_predmeta, String naziv_predmeta, int id_profesora) {
        this.sifra_predmeta = sifra_predmeta;
        this.naziv_predmeta = naziv_predmeta;
        this.id_profesora = id_profesora;
    }

    public Predmet(int id, String sifra_predmeta, String naziv_predmeta, int id_profesora) {
        this.id = id;
        this.sifra_predmeta = sifra_predmeta;
        this.naziv_predmeta = naziv_predmeta;
        this.id_profesora = id_profesora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSifra_predmeta() {
        return sifra_predmeta;
    }

    public void setSifra_predmeta(String sifra_predmeta) {
        this.sifra_predmeta = sifra_predmeta;
    }

    public String getNaziv_predmeta() {
        return naziv_predmeta;
    }

    public void setNaziv_predmeta(String naziv_predmeta) {
        this.naziv_predmeta = naziv_predmeta;
    }

    public int getId_profesora() {
        return id_profesora;
    }

    public void setId_profesora(int id_profesora) {
        this.id_profesora = id_profesora;
    }

    @Override
    public String toString() {
        return "Predmet{" + "id=" + id + ", sifra_predmeta=" + sifra_predmeta + ", naziv_predmeta=" + naziv_predmeta + ", id_profesora=" + id_profesora + '}';
    }

    
    
    
    

}
