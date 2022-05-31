#pragma once
#include<iostream>
using namespace std;
#include <exception>

class DeljenjeSaNulomException : public exception {
public:
	virtual const char* what() const noexcept {
		return "Deljenje sa nulom!";
	}
};
