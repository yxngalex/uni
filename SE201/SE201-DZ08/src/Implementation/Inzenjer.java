package Implementation;

import Interface.IOdrzavanjeAplikacije;

public class Inzenjer extends Osoba implements IOdrzavanjeAplikacije {
    private String diploma;

    public Osoba osoba;

    public String getdiploma() {
        return diploma;
    }

    public void setdiploma(String newDiploma) {
        diploma = newDiploma;
    }

    public Inzenjer(String diploma) {
        // TODO: implement
    }

    public Inzenjer() {
        // TODO: implement
    }

    @Override
    public void sacuvaj() {

    }
}