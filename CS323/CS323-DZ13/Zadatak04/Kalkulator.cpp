#include "Kalkulator.h"
#include "DeljenjeSaNulomException.h"
#include "NeparanBrojException.h"

Kalkulator::Kalkulator() {

}

Kalkulator::Kalkulator(int a, int b) {
	this->a = a;
	this->b = b;
}

Kalkulator::~Kalkulator() {
	cout << "Kalkulator je unisten";
}

void Kalkulator::setA(int a) {
	this->a = a;
}

void Kalkulator::setB(int b) {
	this->b = b;
}

int Kalkulator::getA() const {
	return a;
}

int Kalkulator::getB() const {
	return b;
}

int Kalkulator::divide(int a, int b) {
	try {
		if (b == 0) {
			throw DeljenjeSaNulomException();
		}
		if (a % 2 == 1 || b % 2 == 1) {
			throw NeparajBrojException();
		}
		return (a / b);
	}
	catch (NeparajBrojException& e) {
		cerr << e.what() << endl;
	}
	catch (DeljenjeSaNulomException& e) {
		cerr << e.what() << endl;
	}
}
