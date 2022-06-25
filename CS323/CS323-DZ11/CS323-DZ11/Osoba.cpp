#include "Osoba.h"

Osoba::Osoba() {

}

Osoba::Osoba(string ime, string prezime, string adresa, string telefon) {
	this->ime = ime;
	this->prezime = prezime;
	this->adresa = adresa;
	this->telefon = telefon;
}

Osoba::~Osoba() {
	cout << "Osoba je obrisana!" << endl;
}

void Osoba::setIme(string ime) {
	this->ime = ime;
}

void Osoba::setPrezime(string prezime) {
	this->prezime = prezime;
}

void Osoba::setAdresa(string adresa) {
	this->adresa = adresa;
}

void Osoba::setTelefon(string telefon) {
	this->telefon = telefon;
}


string Osoba::getIme() const {
	return ime;
}
string Osoba::getPrezime() const {
	return prezime;
}
string Osoba::getAdresa() const {
	return adresa;
}

string Osoba::getTelefon() const {
	return telefon;
}

string Osoba::toString() {
	string str = ime;
	str += " " + prezime;
	str += " " + adresa;
	str += " " + telefon;
	return str;
}
