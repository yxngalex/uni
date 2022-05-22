#include "Zaposleni.h"

Zaposleni::Zaposleni(int idZaposlenog) { 
	this->idZaposlenog = idZaposlenog;
}

Zaposleni::Zaposleni() { 
}

Zaposleni::~Zaposleni() { 
	cout << "Zaposleni je obrisan!" << endl;
}

void Zaposleni::setId(int id) {
	this->idZaposlenog = id;
}

int Zaposleni::getId() {
	return idZaposlenog;
}

string Zaposleni::toString() {
	string str = ime;
	str += " " + prezime;
	str += " " + adresa;
	str += " " + telefon;
	str += " " + idZaposlenog;
	return str;
}
