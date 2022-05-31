#include<iostream>
#include<math.h>
using namespace std;
#pragma once
class Kalkulator {
private:
	int a, b;
public:
	Kalkulator();
	Kalkulator(int a, int b);
	~Kalkulator();

	void setA(int a);
	void setB(int b);

	int getA() const;
	int getB() const;

	int divide(int a, int b);
};

