package cs101.pz.prodavnica;

import java.util.Scanner;

public class Kupac extends Osoba {

    private double novac;

    public Kupac() {
    }

    public Kupac(String ime, String prezime, String jmbg, double novac) {
        super(ime, prezime, jmbg);
        this.novac = novac;
    }

    public double getNovac() {
        return novac;
    }

    public void setNovac(double novac) {
        this.novac = novac;
    }

    @Override
    public void ucitajOsobu() {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("UNESI IME KUPCA");
        System.out.print(">:");
        this.setIme(ulaz.next());
        System.out.println("UNESI PREZIME KUPCA:");
        System.out.print(">:");
        this.setPrezime(ulaz.next());
        System.out.println("UNESI JMBG KUPCA:");
        System.out.print(">:");
        this.setJmbg(ulaz.next());
        System.out.println("UNESI BUDZET KUPCA:");
        System.out.print(">:");
        this.setNovac(ulaz.nextDouble());
        System.out.println("-----------------------");

    }

    @Override
    public void prikaziOsobu() {
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("PRIKAZUJEM PODATKE O KUPCU:");
        System.out.println("IME: " + this.getIme());
        System.out.println("PREZIME: " + this.getPrezime());
        System.out.println("JMBG: " + this.getJmbg());
        System.out.println("BUDZET KUPCA JE: " + this.getNovac());
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
    }

    @Override
    public String toString() {
        return "Kupac{" + "novac=" + novac + '}';
    }
}
