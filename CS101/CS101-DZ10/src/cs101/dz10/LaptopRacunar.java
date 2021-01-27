package cs101.dz10;

import java.util.Random;

public class LaptopRacunar extends Racunar{
    private String ime;
    private String jacinaBaterije;

    public LaptopRacunar() {
    }

    public LaptopRacunar(String ime, String jacinaBaterije) {
        this.ime = ime;
        this.jacinaBaterije = jacinaBaterije;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getJacinaBaterije() {
        return jacinaBaterije;
    }

    public void setJacinaBaterije(String jacinaBaterije) {
        this.jacinaBaterije = jacinaBaterije;
    }

    @Override
    public String toString() {
        return "LaptopRacunar{" + "ime=" + ime + ", jacinaBaterije=" + jacinaBaterije + '}';
    }
    
    @Override
    public int racunajCenu() {
        Random rand = new Random();
        int odCena = 60000;
        int doCena = 200001;
        int broj = rand.nextInt(doCena - odCena) + odCena;
        return broj;
    }

}
