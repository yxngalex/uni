package cs101.dz08.zadatak3;

public class Zadatak3 {

    /*
Jednu trafiku definiše njeno ime, adresa, proizvodi. Svaka kupovina ima proizvode koji su kupljeni kao i ukupnu cenu te kupovine. 
Svaki proizvod ima svoje ime i cenu. 
Napisati odgovarajuće klase i testirati kreiranjem više kupovina sa proizvoljnim brojem proizvoda u svakoj od njih.
Izračunati i prikazati  trenutno stanje u kasi nakon svih  kupovina. 
Napomena: Svaka od klasa treba da ima getere i setere za sve atribute, kao i odgovarajuće konstruktore.
     */ 
    public static void main(String[] args) {
        Trafika trafika = new Trafika("CicoRico", "Palilula");
        
        Proizvod cips = new Proizvod("Chipsy", 110);
        Proizvod sok = new Proizvod("Fanta", 120);
        Proizvod grisini = new Proizvod("Pardon", 75);
        Proizvod pivo = new Proizvod("Nisko",130);
        Proizvod jafa = new Proizvod("jafa", 115);
        Proizvod kokice = new Proizvod("Kokice", 180);
        Proizvod vino = new Proizvod("Vranac", 600);
        
        trafika.dodajProizvod(pivo);
        trafika.dodajProizvod(sok);
        trafika.dodajProizvod(grisini);
        trafika.dodajProizvod(jafa);
        trafika.dodajProizvod(cips);
        trafika.dodajProizvod(kokice);
        
        Kupovina kupujem = new Kupovina();
        kupujem.dodajUKorpu(pivo);
        kupujem.dodajUKorpu(sok);
        kupujem.dodajUKorpu(grisini);
        kupujem.dodajUKorpu(jafa);
        kupujem.dodajUKorpu(cips);
        
        System.out.println("Ukupna cena prve kupovine je : " + kupujem.ukupnaCena() + " dinara.");
        System.out.println("Najskuplji proizvod je : " + kupujem.najskupljiProizvod().getIme() + " , i njegova cena je: " + kupujem.najskupljiProizvod().getCena() + " dinara.");
        
        trafika.dodajKupovinu(kupujem);
        Kupovina kupujem1 = new Kupovina();
        kupujem1.dodajUKorpu(vino);
        kupujem1.dodajUKorpu(kokice);
        
        System.out.println("Ukupna cena druge kupovine je : " + kupujem1.ukupnaCena() + " dinara.");
        System.out.println("Najskuplji proizvod druge kupovine je : " + kupujem1.najskupljiProizvod().getIme() + ", i njegova cena je: " + kupujem1.najskupljiProizvod().getCena() + " dinara.");
        
        trafika.dodajKupovinu(kupujem1);
        System.out.print("\n");
        System.out.println("Stanje u kasi je: " + trafika.stanjeKase() + " dinara.");
    }

}
