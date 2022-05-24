#include "Lekar.h"

Lekar::Lekar() {

}


Lekar::~Lekar() {
    cout << "Lekar objekat je unisten" << endl;
}

void Lekar::setImeZavrsenogFakulteta(string imeZavrsenogFakulteta) {
    this->imeZavrsenogFakulteta = imeZavrsenogFakulteta;
}

string Lekar::getImeZavrsenogFakulteta() const {
    return imeZavrsenogFakulteta;
}

void Lekar::infoLekar() {
    cout << "Naziv fakulteta: " << this->imeZavrsenogFakulteta << endl;
}

bool Lekar::operator==(const Lekar &l) {
    if (this->ime.compare(l.ime) == 0
        && this->prezime.compare(l.prezime) == 0
        && this->adresa.compare(l.adresa) == 0
        && this->godiste == (l.godiste) == 0
        && this->datumRodj == (l.datumRodj) == 0
        && this->imeZavrsenogFakulteta == l.imeZavrsenogFakulteta) {
        return true;
    }
    return false;
}
