package implementation;

import interfaceClasses.IAnimacijaModela;
import interfaceClasses.IDizajniranjeModelaILikova;

import java.util.Scanner;

public class Animacija implements IAnimacijaModela, IDizajniranjeModelaILikova {
    private String verzija;
    private String dimenzije;
    private String tehnologija;
    private String engine;

    public String getVerzija() {
        return verzija;
    }

    public void setVerzija(String verzija) {
        this.verzija = verzija;
    }

    public String getDimenzije() {
        return dimenzije;
    }

    public void setDimenzije(String dimenzije) {
        this.dimenzije = dimenzije;
    }

    public String getTehnologija() {
        return tehnologija;
    }

    public void setTehnologija(String tehnologija) {
        this.tehnologija = tehnologija;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Animacija() {

    }

    @Override
    public boolean postojanjeModela(Model model) {
        return model.exists();
    }

    @Override
    public void kreirajNoviModel() {
        Scanner sc = new Scanner(System.in);
        Model model = new Model();
        System.out.println("Nazovite vaseg modela: ");
        model.setNaziv(sc.next());
        System.out.println("Koje boje zelite da bude vas model: ");
        model.setBoja(sc.next());
        System.out.println("Koje dimenzije zelite da vas model bude: ");
        model.setDimenzije(sc.next());
        System.out.println("Kog oblika zelite da vas model bude: ");
        model.setOblik(sc.next());

        sc.close();

        System.out.println("Vas model je uspesno kreiran!");
    }

    @Override
    public void izborAnimacija() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Izaberite koju animaciju zelite: ");
        int num = sc.nextInt();
        System.out.println("Animacija 1");
        System.out.println("Animacija 2");
        System.out.println("Animacija 3");
        System.out.println("Animacija 4");
        System.out.println("Nijedna (0)");
        System.out.println(">");
        switch (num) {
            case 1:
                System.out.println("Izabrali ste animaciju 1");
                break;
            case 2:
                System.out.println("Izabrali ste animaciju 2");
                break;
            case 3:
                System.out.println("Izabrali ste animaciju 3");
                break;
            case 4:
                System.out.println("Izabrali ste animaciju 4");
                break;
            default:
                System.out.println("Niste izabrali ni jednu animaciju");
                break;
        }
    }

    @Override
    public String animiraj() {
        return "Uspesno ste animirali!";
    }

    @Override
    public String animirajModel() {
        return "Model je uspesno animiran!";
    }
}