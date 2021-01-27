package cs101.pz.prodavnica;

import java.util.Scanner;

public class Prodavac extends Osoba {

    private boolean pauza;

    public Prodavac(String ime, String prezime, String jmbg, boolean pauza) {
        super(ime, prezime, jmbg);
        this.pauza = pauza;
    }

    public Prodavac() {
    }

    public boolean isPauza() {
        return pauza;
    }

    /*
    public boolean proveraPauza() {
        if (pauza) {
            return true;
        }
        else{
            return false;
        }
    }
     */
    public void setPauza(boolean pauza) {
        this.pauza = pauza;
    }

    @Override
    public String toString() {
        return "Prodavac{" + "pauza=" + pauza + '}';
    }

    @Override
    public void ucitajOsobu() {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("UNESI IME PRODAVCA");
        System.out.print(">:");
        this.setIme(ulaz.next());
        System.out.println("UNESI PREZIME PRODAVCA:");
        System.out.print(">:");
        this.setPrezime(ulaz.next());
        System.out.println("UNESI JMBG PRODAVCA:");
        System.out.print(">:");
        this.setJmbg(ulaz.next());
        System.out.println("DA LI JE PRODAVAC NA PAUZI?:");
        System.out.print(">:");
        this.setPauza(ulaz.nextBoolean());
        System.out.println("-----------------------");
    }

    @Override
    public void prikaziOsobu() {
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("PRIKAZUJEM PODATKE O PRODAVCU:");
        System.out.println("IME: " + this.getIme());
        System.out.println("PREZIME: " + this.getPrezime());
        System.out.println("JMBG: " + this.getJmbg());
        System.out.println("NA PAUZI JE: " + this.isPauza());
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
    }
}
