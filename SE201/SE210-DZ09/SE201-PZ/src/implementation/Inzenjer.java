package implementation;

import interfaceClasses.IOdrzavanjeAplikacije;

public class Inzenjer extends Osoba implements IOdrzavanjeAplikacije {
    private String diploma;

    public Osoba osoba;

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public Inzenjer(String diploma) {
        this.diploma = diploma;
    }

    public Inzenjer() {
    }

    @Override
    public String sacuvaj() {
        return "Uspesno ste sacuvali inzenjera!";
    }
}