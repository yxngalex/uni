package cs101.dz10;

public abstract class Racunar {

    private String ime;

    protected Racunar() {
    }

    public abstract int racunajCenu();

    protected Racunar(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

}
