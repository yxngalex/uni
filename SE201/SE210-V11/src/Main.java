public class Main {
    public static void main(String[] args) {
        Lek lek1 = new Lek("Brufen", "12.05.2021");
        Lek lek2 = new Lek("Aspirin", "12.05.2021");
        Lek lek3 = new Lek("Bensedin", "12.05.2021");

//        List<Lek> lekovi = new ArrayList<>();
//
//        lekovi.add(lek1);
//        lekovi.add(lek2);
//        lekovi.add(lek3);



        Apoteka a = Apoteka.getApoteka();

        // Setovati magacinima lekove


        Porudzbina p1 = new Porudzbina();

        p1.dodajLek(lek1);
        p1.dodajLek(lek2);
        p1.dodajLek(lek3);


        Klijent k1 = new Klijent("Darko", "Darkovic", "Stevan Sindjelic", p1);

        k1.getPorudzbina().naruci();
    }
}
