public class Lek {
    private String ime;
    private String datumIsteka;

    public Lek() {
    }

    public Lek(String ime, String datumIsteka) {
        this.ime = ime;
        this.datumIsteka = datumIsteka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(String datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    @Override
    public String toString() {
        return "Lek{" +
                "ime='" + ime + '\'' +
                ", datumIsteka=" + datumIsteka +
                '}';
    }
}
