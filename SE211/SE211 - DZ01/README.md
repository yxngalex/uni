# DOMAĆI ZADATAK 1

`Tekst zadatka:` Odabrati proizvoljnu aplikaciju i izvršiti sledeće:

## 1. Prikazati primer dobro formatirane klase unutar aplikacije.

Primer je uzet sa individualnih vežbi.

```java
package seasons;

import java.util.Scanner;

/**
 *  This CheckSeasons class checks which season it is based on month and day from standard input.
 *
 *  @author Asus
 *  @version 1.0
 *  @since 2020-02-20
 */
public class CheckSeasons {

    /**
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        //Initializing Scanner to let user choose month and day from standard input.
        Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();
        int day = scan.nextInt();

        //Prints in standard output.
        System.out.println(checkSeasons(month, day));
    }

    /**
     * This function checks which seasons it is based on month and day.
     *
     * @param month Integer value which represents a month.
     * @param day Integer value which represents a day.
     * @return result - String value where season is stored.
     */
    public static String checkSeasons(int month, int day) {
        //Declare and initialize result variable.
        String result = "";

        //Main logic for checking seasons.
        if ((month == 12 && day >= 16 && day <= 31) || (month == 1 && day >= 1 && day <= 31) || (month == 2 && day >= 1 && day <= 28) || (month == 3 && day >= 1 && day <= 15)) {
            result = "Winter";
        } else if ((month == 3 && day >= 16 && day <= 31) || (month == 4 && day >= 1 && day <= 30) || (month == 5 && day >= 1 && day <= 31) || (month == 6 && day >= 1 && day <= 15)) {
            result = ("Spring");
        } else if ((month == 6 && day >= 16 && day <= 30) || (month == 7 && day >= 1 && day <= 31) || (month == 8 && day >= 1 && day <= 31) || (month == 9 && day >= 1 && day <= 15)) {
            result = ("Summer");
        } else if ((month == 9 && day >= 16 && day <= 30) || (month == 10 && day >= 1 && day <= 31) || (month == 11 && day >= 1 && day <= 30) || (month == 12 && day >= 1 && day <= 15)) {
            result = ("Fall");
        }
        //Return result variable.
        return result;
    }
}
```

## 2. Navesti vrste komentara i načine na koje je moguće komentarisati programski kod.

    * Generalni komentar na pocetku samog fajla. On opisuje svrhu fajla. Izmedju ostalog taj deo komentara moze da sadrzi informacije o autoru zajedno sa kontakt informacijama (npr. email) ili na primer informacije o licenci izvornog koda koji zadrzi.

    * Komentarisanje metoda i funkcija. Komentari ovde sluze da pojasne sta funkcija ili metoda radi i opciono opisuje povratni tip podataka kao i sve parametre koje funcija prima kao argumente.

    * Komentarisanje individualnih linija. Pomaze da objasni rezultat odredjene linije. To moze da bude korisno u slucajevima gde se mora isposovati odredjena procedura izvrsavnja instrukcija ili na primer kod odredjenih optimizacija gde moze doci do necitljivog koda. Slican primer je i komentarisanje klasa ili sturktura.

## 3. Prikazati način na koji se vrši komentarisanje programskog koda unutar aplikacije

Ovde je prikazan način komentarisanja koda unutar neke aplikacije.

### Single line komentar

```java
    // System.out.println("Zakomentarisan deo koda.");
```

### Multiline komentar

```java
    /*
        System.out.println("Zakomentarisan deo koda.");
    */
```

### Java docs komentar

```java
    /**
    * Returns an Image object that can then be painted on the screen.
    * The url argument must specify an absolute <a href="#{@link}">{@link URL}</a>. The name
    * argument is a specifier that is relative to the url argument.
    * <p>
    * This method always returns immediately, whether or not the
    * image exists. When this applet attempts to draw the image on
    * the screen, the data will be loaded. The graphics primitives
    * that draw the image will incrementally paint on the screen.
    *
    * @param  url  an absolute URL giving the base location of the image
    * @param  name the location of the image, relative to the url argument
    * @return      the image at the specified URL
    * @see         Image
    */
public Image getImage(URL url, String name) {

    try {
        return getImage(new URL(url, name));
    } catch (MalformedURLException e) {
        return null;
    }
}
```
