import exceptions.LoginException;
import exceptions.UserCredentialsException;
import implementation.Inzenjer;
import implementation.Korisnik;
import implementation.Osoba;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            userCredential();
        } catch (UserCredentialsException ex) {
            ex.printStackTrace();
        }
    }

    public static void userCredential() throws UserCredentialsException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Da li je korisnik programer ili inzenjer: ");
        String input = sc.next();
        if (input.equalsIgnoreCase("programer")) {
            System.out.println("Korisnik je programer");
            try {
                createUser();
            } catch (LoginException e) {
                e.printStackTrace();
            }
        } else if (input.equalsIgnoreCase("inzenjer")) {
                createEngineer();
        } else {
            throw new UserCredentialsException("Korisnik nije lepo unesen");
        }
    }

    public static void createUser() throws LoginException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Da li imate nalog?");
        String input = sc.next();
        if (input.equalsIgnoreCase("da")) {
            System.out.println("Ulogujte se");
            Korisnik k = new Korisnik();
            System.out.println("Unesite ime korisnika: ");
            String ime = sc.next();
            k.setime(ime);
            System.out.println("Unesite sifru:");
            String sifra = sc.next();
            k.setsifra(sifra);
            k.verifikacijaKorisnika(ime, sifra);
        } else if (input.equalsIgnoreCase("ne")) {
            System.out.println("Da li zelite da napravite nalog?");
            String input2 = sc.next();
            if (input2.equalsIgnoreCase("da")) {
                Korisnik k = new Korisnik();
                System.out.println("Unesite ime vaseg korisnika: ");
                String ime = sc.next();
                k.setime(ime);
                System.out.println("Unesite prezime vaseg korisnika: ");
                String prezime = sc.next();
                k.setprezime(prezime);
                System.out.println("Unesite emial vaseg korisnika: ");
                String email = sc.next();
                k.setemail(email);
                System.out.println("Unesite sifru vaseg korisnika: ");
                String sifra = sc.next();
                k.setsifra(sifra);
                System.out.println("Unesite broj telefona vaseg korisnika: ");
                String brojT = sc.next();
                k.setbrojTelefona(brojT);
                System.out.println("Uspesno ste se registrovali!");
            } else if (input2.equalsIgnoreCase("ne")) {
                System.out.println("Kraj!");
            } else {
                throw new LoginException("Morate izabrati da ili ne!");
            }
        }
        sc.close();
    }

    public static void createEngineer() throws UserCredentialsException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Da li imate nalog?");
        String input = sc.next();
        if (input.equalsIgnoreCase("da")) {
            Inzenjer i = new Inzenjer();
            Korisnik k = new Korisnik();
            System.out.println("Unesite ime inzenjera!");
            String ime = sc.next();
            i.setime(ime);
            System.out.println("Unesite sifru inzenjera!");
            String sifra = sc.next();
            i.setsifra(sifra);
            k.verifikacijaKorisnika(i.getime(), i.getsifra());
        } else if (input.equalsIgnoreCase("ne")) {
            Inzenjer i = new Inzenjer();
            System.out.println("Unesite diplomu vaseg inzenjera: ");
            String diploma = sc.next();
            i.setDiploma(diploma);
            System.out.println("Unesite ime vaseg inzenjera: ");
            Osoba o = new Korisnik();
            String ime = sc.next();
            o.setime(ime);
            System.out.println("Unesite prezime vaseg inzenjera: ");
            String prezime = sc.next();
            o.setprezime(prezime);
            System.out.println("Unesite emial vaseg inzenjera: ");
            String email = sc.next();
            o.setemail(email);
            System.out.println("Unesite sifru vaseg inzenjera: ");
            String sifra = sc.next();
            o.setsifra(sifra);
            System.out.println("Unesite broj telefona vaseg inzenjera: ");
            String brojT = sc.next();
            o.setbrojTelefona(brojT);
            i.setOsoba(o);
        } else {
           throw new UserCredentialsException("Inzenjer nije lepo unesen!");
        }
        sc.close();
    }
}
