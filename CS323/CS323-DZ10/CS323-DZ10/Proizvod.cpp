#include "Proizvod.h"


Proizvod::Proizvod() {

}

Proizvod::Proizvod(string ime, string barKod, string sifra, double cena) {
	this->ime = ime;
	this->barKod = barKod;
	this->sifra = sifra;
	this->cena = cena;
}

Proizvod::~Proizvod() {
	cout << "Proizvod je obrisan" << endl;
}

void Proizvod::setIme(string ime) {
	this->ime = ime;
}

void Proizvod::setBarKod(string barKod) {
	this->barKod = barKod;
}

void Proizvod::setSifra(string sifra) {
	this->sifra = sifra;
}

void Proizvod::setCena(double cena) {
	this->cena = cena;
}

string Proizvod::getIme() const {
	return ime;
}
string Proizvod::getBarKod() const {
	return barKod;
}
string Proizvod::getSifra() const {
	return sifra;
}
double Proizvod::getCena() const {
	return cena;
}

void Proizvod::info() {
	cout << "Cena proizvoda je " << this->cena << endl;
}
