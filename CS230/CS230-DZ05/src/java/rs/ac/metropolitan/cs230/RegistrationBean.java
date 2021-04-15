package rs.ac.metropolitan.cs230;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RegistrationBean {

    private int starost;
    private String email;
    private VrstaStudiranja vrstaStudiranja;
    private String ime;
    private String prezime;
    private Fakultet fakultet;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public VrstaStudiranja getVrstaStudiranja() {
        return vrstaStudiranja;
    }

    public void setVrstaStudiranja(VrstaStudiranja vrstaStudiranja) {
        this.vrstaStudiranja = vrstaStudiranja;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

}

enum Fakultet {
    FIT,
    FAD,
    FMD
}

enum VrstaStudiranja {
    ONLINE,
    TRADICIONALAN
}
