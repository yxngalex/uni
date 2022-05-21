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
