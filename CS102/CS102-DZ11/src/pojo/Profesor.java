package pojo;

import java.util.ArrayList;
import java.util.List;

public class Profesor {

    private int id;
    private String ime;
    private String prezime;
    private int godina_izbora_u_zvanje;
    private String naslov_doktorata;

    public Profesor(String ime, String prezime, int godina_izbora_u_zvanje, String naslov_doktorata) {
        this.ime = ime;
        this.prezime = prezime;
        this.godina_izbora_u_zvanje = godina_izbora_u_zvanje;
        this.naslov_doktorata = naslov_doktorata;
    }

    public Profesor() {
    }

    public Profesor(int id, String ime, String prezime, int godina_izbora_u_zvanje, String naslov_doktorata) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.godina_izbora_u_zvanje = godina_izbora_u_zvanje;
        this.naslov_doktorata = naslov_doktorata;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getGodina_izbora_u_zvanje() {
        return godina_izbora_u_zvanje;
    }

    public void setGodina_izbora_u_zvanje(int godina_izbora_u_zvanje) {
        this.godina_izbora_u_zvanje = godina_izbora_u_zvanje;
    }

    public String getNaslov_doktorata() {
        return naslov_doktorata;
    }

    public void setNaslov_doktorata(String naslov_doktorata) {
        this.naslov_doktorata = naslov_doktorata;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", godina_izbora_u_zvanje=" + godina_izbora_u_zvanje + ", naslov_doktorata=" + naslov_doktorata + '}';
    }

}
