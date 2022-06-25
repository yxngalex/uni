#include "Student.h"


Student::Student(int index) {
	this->index = index;
	}

Student::Student() {

	}

Student::~Student() {
	cout << "Student je unisten!" << endl;
	}

void Student::setIndex(int index) {
	this->index = index;

	}

int Student::getIndex() {
	return index;
	}

string Student::toString() {
	string str = ime;
	str += " " + prezime;
	str += " " + adresa;
	str += " " + telefon;
	str += " " + index;
	return str;
}
