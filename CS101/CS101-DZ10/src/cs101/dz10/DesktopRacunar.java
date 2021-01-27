package cs101.dz10;

import java.util.Random;

public class DesktopRacunar extends Racunar {
    
    private String ime;
    private String visina;
    private String sirina;
    private String duzina;

    public DesktopRacunar() {
    }

    public DesktopRacunar(String ime, String visina, String sirina, String duzina) {
        this.ime = ime;
        this.visina = visina;
        this.sirina = sirina;
        this.duzina = duzina;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }   

    public String getVisina() {
        return visina;
    }

    public void setVisina(String visina) {
        this.visina = visina;
    }

    public String getSirina() {
        return sirina;
    }

    public void setSirina(String sirina) {
        this.sirina = sirina;
    }

    public String getDuzina() {
        return duzina;
    }

    public void setDuzina(String duzina) {
        this.duzina = duzina;
    }

    @Override
    public String toString() {
        return "DesktopRacunar{" + "ime=" + ime + ", visina=" + visina + ", sirina=" + sirina + ", duzina=" + duzina + '}';
    }

    @Override
    public int racunajCenu() {
        Random rand = new Random();
        int odCena = 40000;
        int doCena = 120001; 
        int broj = rand.nextInt(doCena - odCena) + odCena;
        return broj;
    }

}
