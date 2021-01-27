package cs101.dz13;

import Exceptions.EmptyFieldException;
import Exceptions.JmbgException;
import java.util.Scanner;

public class Zaposleni {

    private String ime;
    private String prezime;
    private long jmbg;

    public Zaposleni() {
    }

    public Zaposleni(String ime, String prezime, long jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public long getJmbg() {
        return jmbg;
    }

    public void setJmbg(long jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + '}';
    }

    public void ucitajZaposlenog() {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("UNESI IME ZAPOSLENOG: ");
        System.out.print(">");
        this.setIme(ulaz.next());
        System.out.println("UNESI PREZIME ZAPOSLENOG:");
        System.out.print(">");
        this.setPrezime(ulaz.next());
        System.out.println("UNESI JMBG ZAPOSLENOG:");
        System.out.print(">");
        this.setJmbg(ulaz.nextLong());
        System.out.println("-----------------------");

    }

    public void prikaziZaposlenog() {
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("PRIKAZUJEM PODATKE O ZAPOSLENOM:");
        System.out.println("IME: " + this.getIme());
        System.out.println("PREZIME: " + this.getPrezime());
        System.out.println("JMBG: " + this.getJmbg());
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
    }

    public void proveraJmbga(long jmbg) throws JmbgException{
        String noviJmbg = Long.toString(jmbg);
        if(noviJmbg.length() != 13){
            throw new JmbgException("JMBG IMA TACNO 13 BROJA");
        }
    }
    
    public void prazanTekst() throws EmptyFieldException{
        String noviJmbg = Long.toString(jmbg);
        if(this.ime == null || this.ime.isEmpty()){
            throw new EmptyFieldException("POLJE IME MORA BITI POPUNJENO!!!");
        } if(this.prezime == null || this.ime.isEmpty()){
            throw new EmptyFieldException("POLJE PREZIME MORA BITI POPUNJENO!!!");
        } if(noviJmbg == null || noviJmbg.isEmpty()){
            throw new EmptyFieldException("POLJE JMBG MORA BITI POPUNJENO!!!");
        }
    }
}
