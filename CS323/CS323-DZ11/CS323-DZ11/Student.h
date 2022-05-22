#include "Osoba.h"
using namespace std;
#pragma once
class Student : public Osoba
{
private:
	int index;
public:
	Student();
	Student(int index);
	virtual ~Student();

	void setIndex(int index);
	int getIndex();

	string toString();

};

