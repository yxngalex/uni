#pragma once
#include<iostream>
using namespace std;
#include <exception>

class NeparajBrojException : public exception {
public:
	virtual const char* what() const noexcept {
		return "Broj je neparan!";
	}
};
