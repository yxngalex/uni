#pragma once
#include<iostream>
using namespace std;
#include <exception>

class CenaNijeValidnaException : public exception {
public:
	virtual const char* what() const noexcept {
		return "Cena nije validna!";
	}
};
