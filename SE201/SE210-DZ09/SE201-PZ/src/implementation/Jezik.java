package implementation;

import interfaceClasses.IBiranjeProgramskogJezika;
import interfaceClasses.IPisanjeFunkcionalnosti;

import java.util.Scanner;

public class Jezik implements IBiranjeProgramskogJezika, IPisanjeFunkcionalnosti {
    private int redniBrojJezika;
    private String imeJezika;

    public int getredniBrojJezika() {
        return redniBrojJezika;
    }

    public void setredniBrojJezika(int newRedniBrojJezika) {
        redniBrojJezika = newRedniBrojJezika;
    }

    public Jezik() {
        // TODO: implement
    }

    @Override
    public void biranjeJezika() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Izaberite programski jezik koji zelite: ");
        int num = sc.nextInt();
        System.out.println("C");
        System.out.println("C++");
        System.out.println("C#");
        System.out.println("Java");
        System.out.println("Python");
        System.out.println(">");
        switch (num) {
            case 1:
                System.out.println("Uspesno ste izabrali C kao vas jezik!");
                break;
            case 2:
                System.out.println("Uspesno ste izabrali C++ kao vas jezik!");
                break;
            case 3:
                System.out.println("Uspesno ste izabrali C# kao vas jezik!");
                break;
            case 4:
                System.out.println("Uspesno ste izabrali Java kao vas jezik!");
                break;
            case 5:
                System.out.println("Uspesno ste izabrali Python kao vas jezik!");
                break;
            default:
                System.out.println("Niste izabrali ni jedan jezik");
                break;
        }
        sc.close();
    }

    @Override
    public String sacuvaj() {
        return "Uspesno ste sacuvali jezik!";
    }
}