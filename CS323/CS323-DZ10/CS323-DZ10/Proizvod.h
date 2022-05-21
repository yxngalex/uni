#pragma once
#include<iostream>
using namespace std;
class Proizvod
{
	// 4. zadatak
protected:
	string ime;
	string barKod;
	string sifra;
	double cena;

public:
	Proizvod();
	Proizvod(string ime, string barKod, string sifra, double cena);
	~Proizvod();

	void setIme(string ime);
	void setBarKod(string barKod);
	void setSifra(string sifra);
	void setCena(double ime);

	string getIme() const;
	string getBarKod() const;
	string getSifra() const;
	double getCena() const;

	void info();
};

