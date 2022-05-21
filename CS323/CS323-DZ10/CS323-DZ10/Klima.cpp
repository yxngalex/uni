#include "Klima.h"

Klima::Klima() {

}

Klima::Klima(string jacina) {
	this->jacina = jacina;
}

Klima::~Klima() {
	cout << "Klima objekat je unisten" << endl;
}

void Klima::setJacina(string jacina) {
	this->jacina = jacina;
	}

string Klima::getJacina() const {
	return jacina;
	}

void Klima::infoKlime() {
	cout << "Ime: " << this->ime << ", cena: " << this->cena << ", jacina: " << this->jacina << ", bar kod: " << this->barKod << ", sifra: " << this->sifra << endl;
}
