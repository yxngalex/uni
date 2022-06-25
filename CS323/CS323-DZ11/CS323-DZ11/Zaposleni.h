#pragma once
#include "Osoba.h"
using namespace std;

class Zaposleni : public Osoba
{
private:
	int idZaposlenog;
public:
	Zaposleni();
	Zaposleni(int idZaposlenog);
	virtual ~Zaposleni();

	void setId(int id);
	int getId();

	string toString();
};

