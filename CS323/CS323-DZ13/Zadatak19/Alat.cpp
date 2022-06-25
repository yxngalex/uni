#include "Alat.h"
#include "CenaNijeValidnaException.h";

Alat::Alat() {

}
Alat::Alat(string ime, string serijskiBroj, int cena) {
	try {
		if (cena >= 0) {
			this->ime = ime;
			this->serijskiBroj = serijskiBroj;
			this->cena = cena;
		}
		else {
			throw CenaNijeValidnaException();
		}
	}
	catch (CenaNijeValidnaException& e) {
		cerr << e.what() << endl;
	}
}
Alat::~Alat() {
	cout << "Alat je unisten!";
}

void Alat::setIme(string ime) {
	this->ime = ime;
}

void Alat::setSerijskiBroj(string serijskiBroj) {
	this->serijskiBroj = serijskiBroj;
}

void Alat::setCena(int cena) {
	try {
		if (cena >= 0) {
			this->cena = cena;
		}
		else {
			throw CenaNijeValidnaException();
		}
	}
	catch (CenaNijeValidnaException& e) {
			cerr << e.what() << endl;
	}
}


string Alat::getIme() const {
	return ime;
}

string Alat::getSerijskiBroj() const {
	return serijskiBroj;
}

int Alat::getCena() const {
	return cena;
}

