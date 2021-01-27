package cs102.dz08;

public class Student {

    private String ime;
    private String prezime;
    private String index;

    public Student() {
    }

    public Student(String ime, String prezime, String index) {
        this.ime = ime;
        this.prezime = prezime;
        this.index = index;
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

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Student{" + "ime=" + ime + ", prezime=" + prezime + ", index=" + index + '}';
    }
}
