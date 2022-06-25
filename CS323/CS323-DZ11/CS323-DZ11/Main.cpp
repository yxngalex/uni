#include "Student.h"
#include "Zaposleni.h"

int main() {
	Student s;
	Zaposleni z;

	s.setIme("Pera");
	s.setPrezime("Peric");
	s.setAdresa("Nis");
	s.setIndex(1234);
	s.setTelefon("1234123451");

	z.setIme("Marko");
	z.setPrezime("Markovic");
	z.setAdresa("Nis");
	z.setTelefon("12341231");
	z.setId(12341);

	cout << s.toString() << endl;
	cout << z.toString() << endl;

	return 0;
}