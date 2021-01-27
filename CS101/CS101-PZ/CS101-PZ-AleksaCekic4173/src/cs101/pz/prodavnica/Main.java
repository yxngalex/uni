package cs101.pz.prodavnica;

import cs101.pz.prodavnica.exception.NemaDovoljnoNovcaException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NemaDovoljnoNovcaException {
        Scanner ulaz = new Scanner(System.in);
        Prodavnica prod = new Prodavnica("Tempo", "Nis", TipProdavnice.market);
        Prodavac p1 = new Prodavac();
        Kupac k1 = new Kupac();
        Kupovina kupovina1 = new Kupovina();
        File dat = new File("kupac.txt");

        k1.ucitajOsobu();
        p1.ucitajOsobu();
        System.out.println("");
        k1.prikaziOsobu();
        p1.prikaziOsobu();

        //Prodavnica radi u zavisnosti od koliko sati unesemo
        System.out.println("UNESI RADNO VREME:");
        System.out.print(">:");
        int n = ulaz.nextInt();
        System.out.println("");
        prod.radnoVreme(n);

        //Pravimo objekte proizvodi sada
        Proizvod proiz1 = new Proizvod("Coca-Cola", 125.0, true);
        Proizvod proiz2 = new Proizvod("Pepsi", 115.0, true);
        Proizvod proiz3 = new Proizvod("Cokalada", 225.0, false);
        Proizvod proiz4 = new Proizvod("Cips", 50.0, false);
        Proizvod proiz5 = new Proizvod("Nisko", 200.5, true);

        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("PROVERA PROIZVODA I PROVERA PAUZE");
        System.out.println("Proizvod 1 " + proiz1.getIme() + " cija je cena " + proiz1.getCena() + " se nalazi u magacinu? " + proiz1.isDostupan());
        System.out.println("Proizvod 2 " + proiz2.getIme() + " cija je cena " + proiz2.getCena() + " se nalazi u magacinu? " + proiz2.isDostupan());
        System.out.println("Proizvod 3 " + proiz3.getIme() + " cija je cena " + proiz3.getCena() + " se nalazi u magacinu? " + proiz3.isDostupan());
        System.out.println("Proizvod 4 " + proiz4.getIme() + " cija je cena " + proiz4.getCena() + " se nalazi u magacinu? " + proiz4.isDostupan());
        System.out.println("Proizvod 5 " + proiz5.getIme() + " cija je cena " + proiz5.getCena() + " se nalazi u magacinu? " + proiz5.isDostupan());
        kupovina1.daLiJePauza(p1);
        System.out.println("-----------------------");

        //ubacujemo proizvode u korpu
        while (true) {
            System.out.print("Unesi broj za proizvod koji bi zeleo da stavis u korpu:");
            int number = ulaz.nextInt();
            switch (number) {
                case 1:
                    kupovina1.dodajUkorpu(proiz1);
                    System.out.println("Ubacili ste u korpu proizvod " + proiz1.getIme() + " , cija je cena: " + proiz1.getCena() + " dinara.");
                    break;
                case 2:
                    kupovina1.dodajUkorpu(proiz2);
                    System.out.println("Ubacili ste u korpu proizvod " + proiz2.getIme() + " , cija je cena: " + proiz2.getCena() + " dinara.");
                    break;
                case 3:
                    kupovina1.dodajUkorpu(proiz3);
                    System.out.println("Ubacili ste u korpu proizvod " + proiz3.getIme() + " , cija je cena: " + proiz3.getCena() + " dinara.");
                    break;
                case 4:
                    kupovina1.dodajUkorpu(proiz4);
                    System.out.println("Ubacili ste u korpu proizvod " + proiz4.getIme() + " , cija je cena: " + proiz4.getCena() + " dinara.");
                    break;
                case 5:
                    System.out.println("Ubacili ste u korpu proizvod " + proiz5.getIme() + " , cija je cena: " + proiz5.getCena() + " dinara.");
                    kupovina1.dodajUkorpu(proiz5);
                    break;
                default:
                    throw new IllegalArgumentException("NAPISITE OD 1 DO 5");
            }
            System.out.println("Da li ste ubacili sve sto ste zeleli u korpi? 1 za da 0 za ne!!!");
            int izbor = ulaz.nextInt();
            if (izbor == 1) {
                break;
            } else if (izbor == 0) {
                continue;
            } else {
                throw new IllegalArgumentException("NAPISITE 0 ILI 1");
            }
        }

        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("DA LI ZELITE DA NASTAVITE DO KASE?");
        System.out.print(">:");
        String a = ulaz.next();
        ulaz.close();
        if (a.equalsIgnoreCase("Da")) {
            System.out.println("NASTAVITE DALJE DO KASE!!!");
        } else if (a.equalsIgnoreCase("Ne")) {
            System.out.println("USPESNO STE IZASLI IZ REDA DO KASE!!!");
            System.exit(0);
        } else {
            throw new IllegalArgumentException("NAPISITE DA ILI NE!!!!");
        }

        System.out.println("");
        System.out.println("-----------------------");
        kupovina1.dostupanProizvod();
        System.out.println("-----------------------");
        System.out.println("UKUPNA CENA ZA SVE OVE PROIZVODE JE: " + kupovina1.ukupnaCena());
        System.out.println("");

        System.out.println("RACUNAM PLACANJE!!!");

        try {
            System.out.println("KUPOVINA USPESNO IZVRSENA!! Vas kusur je: " + kupovina1.izvrsenjeKupovine(k1));
        } catch (NemaDovoljnoNovcaException e) {
            System.out.println(e.getMessage());
        }

        try {
            PrintWriter pw = new PrintWriter(dat);
            pw.println("Ime Kupca: " + k1.getIme());
            pw.println("Prezime Kupca: " + k1.getPrezime());
            pw.println("Jmbg Kupca: " + k1.getJmbg());
            pw.println("Kusur: " + kupovina1.izvrsenjeKupovine(k1));
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Datoteka vec postoji!!!");
        } finally {
            System.out.println("Kraj upisa!!!");
        }
    }

}
