#pragma once
#include<iostream>
using namespace std;

class Zaposleni
{
	// 14. zadatak
protected:
	string ime;
	string prezime;
	string adresa;
	string telefon;
	string godiste;
	string datumRodj;

public:
	Zaposleni();
	~Zaposleni();

	void setIme(string ime);
	void setPrezime(string prezime);
	void setAdresa(string adresa);
	void setTelefon(string telefon);
	void setGodiste(string godiste);
	void setDatumRodj(string datumRodj);

	string getIme() const;
	string getPrezime() const;
	string getAdresa() const;
	string getTelefon() const;
	string getGodiste() const;
	string getDatumRodj() const;

	void info();
};

