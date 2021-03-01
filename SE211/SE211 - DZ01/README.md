# DOMAĆI ZADATAK 1

`Tekst zadatka:` Odabrati proizvoljnu aplikaciju i izvršiti sledeće:

## 1. Prikazati primer dobro formatirane klase unutar aplikacije.

Za ovaj primer uzeta su dva objekta biblioteke i knjige.

### Klasa Knjiga

```java
import java.util.Date;

/**
 * This Book class represents a real book. It has these attributes to describe this book.
 *
 * @author Aleksa
 * @version 1.0
 * @since 2020-02-20
 */

public class Book {

    /**
     * name of a book
     */
    private String name;

    /**
     * name of an author
     */
    private String author;

    /**
     * id of a book
     */
    private Integer id;

    /**
     * date when this book was released
     */
    private Date releaseDate;


    /**
     * This is a default constructor to initialize book object.
     */
    public Book() {
    }

    /**
     * This is a constructor to initialize book object with params.
     *
     * @param name
     * @param author
     * @param id
     * @param releaseDate
     */
    public Book(String name, String author, Integer id, Date releaseDate) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.releaseDate = releaseDate;
    }

    /**
     * get book name
     * @return book name
     */
    public String getName() {
        return name;
    }

    /**
     * set book name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get book author
     * @return book author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * set book author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get book id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * set book id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get release date
     * @return releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * set release date
     * @param releaseDate
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * return back this object with attributes as string
     * @return Book
     */
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", releaseDate=" + releaseDate +
                '}';
    }
}

```

### Klasa Biblioteka

```java
import java.util.List;

/**
 * This Library class represents a library with books stored in it. Attributes defined inside this class represents a real life library.
 *
 * @author Aleksa
 * @version 1.0
 * @since 2020-02-20
 */
public class Library {
    /**
     * list of books inside library
     */
    private List<Book> bookList;
    /**
     * name of a library
     */
    private String nameOfLibrary;
    /**
     * library address
     */
    private String address;


    /**
     * default constructor
     */
    public Library() {
    }

    /**
     * This is a constructor to initialize library object with params.
     *
     * @param bookList
     * @param nameOfLibrary
     * @param address
     */
    public Library(List<Book> bookList, String nameOfLibrary, String address) {
        this.bookList = bookList;
        this.nameOfLibrary = nameOfLibrary;
        this.address = address;
    }

    /**
     * get books as a list
     * @return bookList
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * set books
     * @param bookList
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * get name of library
     * @return name
     */
    public String getNameOfLibrary() {
        return nameOfLibrary;
    }

    /**
     * set name of library
     * @param nameOfLibrary
     */
    public void setNameOfLibrary(String nameOfLibrary) {
        this.nameOfLibrary = nameOfLibrary;
    }

    /**
     * get library address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * set address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Return library object as to String
     * @return Library
     */
    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                ", nameOfLibrary='" + nameOfLibrary + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

```

## 2. Navesti vrste komentara i načine na koje je moguće komentarisati programski kod.

- Generalni komentar na pocetku samog fajla. On opisuje svrhu fajla. Izmedju ostalog taj deo komentara moze da sadrzi informacije o autoru zajedno sa kontakt informacijama (npr. email) ili na primer informacije o licenci izvornog koda koji zadrzi.

- Komentarisanje metoda i funkcija. Komentari ovde sluze da pojasne sta funkcija ili metoda radi i opciono opisuje povratni tip podataka kao i sve parametre koje funcija prima kao argumente.

- Komentarisanje individualnih linija. Pomaze da objasni rezultat odredjene linije. To moze da bude korisno u slucajevima gde se mora isposovati odredjena procedura izvrsavnja instrukcija ili na primer kod odredjenih optimizacija gde moze doci do necitljivog koda. Slican primer je i komentarisanje klasa ili sturktura.

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
