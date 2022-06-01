#pragma once
#include "Zaposleni.h"
#include <iostream>
using namespace std;

class Lekar : public Zaposleni
{
protected:
    string imeZavrsenogFakulteta;
public:
    Lekar();
    ~Lekar();

    void setImeZavrsenogFakulteta(string imeZavrsenogFakulteta);
    string getImeZavrsenogFakulteta() const;
    void infoLekar();

    bool operator==(const Lekar& l);

    friend ostream& operator<<(ostream& out, const Lekar& l);
 };