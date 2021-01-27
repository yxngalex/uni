package implementation;

import interfaceClasses.IDizajniranjeModelaILikova;
import interfaceClasses.IGraficko3dModelovanje;
import interfaceClasses.IPravljenjeNivoa;

import java.util.Scanner;

public class Model implements IPravljenjeNivoa, IGraficko3dModelovanje, IDizajniranjeModelaILikova {
    private String naziv;
    private String oblik;
    private String boja;
    private String dimenzije;

    public java.util.Collection<Animacija> animacija;

    public Model() {
    }

    public boolean exists() {
        return true;
    }

    public java.util.Collection<Animacija> getAnimacija() {
        if (animacija == null)
            animacija = new java.util.HashSet<Animacija>();
        return animacija;
    }

    public java.util.Iterator getIteratorAnimacija() {
        if (animacija == null)
            animacija = new java.util.HashSet<Animacija>();
        return animacija.iterator();
    }

    public void setAnimacija(java.util.Collection<Animacija> newAnimacija) {
        removeAllAnimacija();
        for (java.util.Iterator iter = newAnimacija.iterator(); iter.hasNext(); )
            addAnimacija((Animacija) iter.next());
    }

    public void addAnimacija(Animacija newAnimacija) {
        if (newAnimacija == null)
            return;
        if (this.animacija == null)
            this.animacija = new java.util.HashSet<Animacija>();
        if (!this.animacija.contains(newAnimacija))
            this.animacija.add(newAnimacija);
    }

    public void removeAnimacija(Animacija oldAnimacija) {
        if (oldAnimacija == null)
            return;
        if (this.animacija != null)
            if (this.animacija.contains(oldAnimacija))
                this.animacija.remove(oldAnimacija);
    }

    public void removeAllAnimacija() {
        if (animacija != null)
            animacija.clear();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOblik() {
        return oblik;
    }

    public void setOblik(String oblik) {
        this.oblik = oblik;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public String getDimenzije() {
        return dimenzije;
    }

    public void setDimenzije(String dimenzije) {
        this.dimenzije = dimenzije;
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
    public void odabirModela() {

    }

    @Override
    public boolean modelPostoji() {
        return false;
    }

    @Override
    public void sacuvaj() {
        System.out.println("Uspesno ste sacuvali inzenjera!");
    }

    @Override
    public void preuzmiNoveRekvizite() {
        System.out.println("Uspesno ste preuzeli nove rekvizite!");
    }

    @Override
    public void pokreniSkidanjeRekvizita() {
        System.out.println("Uspesno ste preuzeli rekvizite!");
    }
}