#include "Zaposleni.h"


Zaposleni::Zaposleni() {

}

Zaposleni::~Zaposleni() {
	cout << "Zaposleni je obrisan" << endl;
}

void Zaposleni::setIme(string ime) {
	this->ime = ime;
}

void Zaposleni::setPrezime(string prezime) {
	this->prezime = prezime;
}

void Zaposleni::setAdresa(string adresa) {
	this->adresa = adresa;
}

void Zaposleni::setTelefon(string telefon) {
	this->telefon = telefon;
}

void Zaposleni::setGodiste(string godiste) {
	this->godiste = godiste;
}

void Zaposleni::setDatumRodj(string datumRodj) {
	this->datumRodj = datumRodj;
}

string Zaposleni::getIme() const {
	return ime;
}
string Zaposleni::getPrezime() const {
	return prezime;
}
string Zaposleni::getAdresa() const {
	return adresa;
}

string Zaposleni::getTelefon() const {
	return telefon;
}

string Zaposleni::getGodiste() const {
	return godiste;
}

string Zaposleni::getDatumRodj() const {
	return datumRodj;
}

void Zaposleni::info() {
	cout << "Ime: " << this->ime << ", Prezime: " << this->prezime << " , Godiste: " << this->godiste << " , Adresa: " << this->adresa << " , Datum Rodjenja: " << this->datumRodj <<  endl;
}

