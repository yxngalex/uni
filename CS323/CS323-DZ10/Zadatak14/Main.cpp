#include "Lekar.h"

int main() {
	// Zadatak 4.
	Lekar l;

	l.setIme("Goran");
	l.setPrezime("Goranovic");
	l.setAdresa("Nis");
	l.setGodiste("1995");
	l.setDatumRodj("5 Avgust");
	l.setTelefon("12345123");
	l.setImeZavrsenogFakulteta("Metropolitan");


	l.info();

	l.infoLekar();


	return 0;
}
