package Implementation;

import java.util.*;

public abstract class Osoba {
   private String ime;
   private String prezime;
   private String sifra;
   private String email;
   private String brojTelefona;
   
   public String getime() {
      return ime;
   }
   
   public void setime(String newIme) {
      ime = newIme;
   }
   
   public String getprezime() {
      return prezime;
   }
   
   public void setprezime(String newPrezime) {
      prezime = newPrezime;
   }
   
   public String getsifra() {
      return sifra;
   }
   
   public void setsifra(String newSifra) {
      sifra = newSifra;
   }
   
   public String getemail() {
      return email;
   }
   
   public void setemail(String newEmail) {
      email = newEmail;
   }
   
   public String getbrojTelefona() {
      return brojTelefona;
   }
   
   public void setbrojTelefona(String newBrojTelefona) {
      brojTelefona = newBrojTelefona;
   }
   
   public Osoba(String ime, String prezime, String sifra, String email, String brojTelefona) {
      this.ime = ime;
      this.prezime = prezime;
      this.sifra = sifra;
      this.email = email;
      this.brojTelefona = brojTelefona;
   }
   
   public Osoba() {
   }

}