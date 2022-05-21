#include "Proizvod.h"
#include "Klima.h"

int main() {
	// Zadatak 4.
	Klima k;

	k.setIme("Toshiba");
	k.setCena(250.35);
	k.setBarKod("beep boop");
	k.setSifra("AC521BW");
	k.setJacina("500W");

	k.infoKlime();


	return 0;
}