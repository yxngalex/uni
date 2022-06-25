#pragma once
#include <iostream>
#include "Proizvod.h"
using namespace std;

class Klima  : public Proizvod
{
protected:
	string jacina;

public:
	Klima();
	Klima(string jacina);
	~Klima();
	void setJacina(string jacina);
	string getJacina() const;
	void infoKlime();
};


