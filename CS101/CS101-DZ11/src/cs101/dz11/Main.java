package cs101.dz11;

public class Main {

    /*
    Napraviti klase Pravougaonik i Valjak, 
    kao i interfejs Izracunljiv koji deklariše dva metoda – 
    racunajPovrsinu() i racunajObim(). Atributi klasa odgovaraju atributima koji su 
    neophodni za izračunavanje površine i zapremine. 
    Klase Pravougaonik i Valjak treba da implementiraju interfejs Izracunljiv,
    tako da metode za računanje obima i površine odgovaraju formulama za računanje
    u skladu sa samim geometrijskim oblikom.
     */
    
    public static void main(String[] args) {
        Pravougaonik p1 = new Pravougaonik(5.0, 3.0);
        Valjak v1 = new Valjak(15.0, 5.0);

        System.out.println("Stampam obime oba objekta: ");
        System.out.println("Obim valjka je: " + v1.racunajObim());
        System.out.println("Obim pravougaonika je: " + p1.racunajPovrsinu());

        System.out.println("Stampam povrsine oba objekta: ");
        System.out.println("Povrsina valjka je: " + v1.racunajPovrsinu());
        System.out.println("Povrsina pravougaonika je: " + p1.racunajPovrsinu());
    }
}
