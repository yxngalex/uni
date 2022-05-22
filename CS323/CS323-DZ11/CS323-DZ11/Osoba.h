#pragma once
#include <iostream>
using namespace std;

class Osoba
{
protected:
	string ime;
	string prezime;
	string adresa;
	string telefon;

public:
	Osoba();
	Osoba(string ime, string prezime, string adresa, string telefon);
	~Osoba();

	void setIme(string ime);
	void setPrezime(string prezime);
	void setAdresa(string adresa);
	void setTelefon(string telefon);

	string getIme() const;
	string getPrezime() const;
	string getAdresa() const;
	string getTelefon() const;

	virtual string toString() = 0;
};

