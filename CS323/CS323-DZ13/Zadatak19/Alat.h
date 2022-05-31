#include <iostream>
#include <string>
using namespace std;
#pragma once
class Alat
{
private:
	string ime, serijskiBroj;
	int cena;

public:
	Alat();
	Alat(string ime, string serijskiBroj, int cena);
	~Alat();

	void setIme(string ime);
	void setSerijskiBroj(string serijskiBroj);
	void setCena(int cena);

	string getIme() const;
	string getSerijskiBroj() const;
	int getCena() const;
};

