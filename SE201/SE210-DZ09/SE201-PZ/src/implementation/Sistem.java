package implementation;

public class Sistem {
    private String poruka;
    private static Sistem sistem;

    private String getporuka() {
        return poruka;
    }

    private void setporuka(String newPoruka) {
        poruka = newPoruka;
    }

    private Sistem() {
    }

    public static Sistem getsistem() {
       if (sistem == null) {
          sistem = new Sistem();
       }
       return sistem;
    }

    private void setsistem(Sistem newSistem) {
        sistem = newSistem;
    }

    public String prikazGui() {
        return "Gui se sada prikazuje";
    }

}