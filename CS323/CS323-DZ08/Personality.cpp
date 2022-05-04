#include <iostream>
#include "Personality.h"

using namespace std;

Personality::Personality() {

}

Personality::Personality(string name, string address, int day, string month, string year) {
    this->name = name;
    this->address = address;
    this->day = day;
    this->month = month;
    this->year = year;
}

Personality::Personality(const Personality &p1) {
    this->name = p1.name;
    this->address = p1.address;
    this->day = p1.day;
    this->month = p1.month;
    this->year = p1.year;
}

const string &Personality::getName() const {
    return name;
}

void Personality::setName(const string &name) {
    Personality::name = name;
}

const string &Personality::getAddress() const {
    return address;
}

void Personality::setAddress(const string &address) {
    Personality::address = address;
}

const int &Personality::getDay() const {
    return day;
}

void Personality::setDay(const int &day) {
    Personality::day = day;
}

const string &Personality::getMonth() const {
    return month;
}

void Personality::setMonth(const string &month) {
    Personality::month = month;
}

const string &Personality::getYear() const {
    return year;
}

void Personality::setYear(const string &year) {
    Personality::year = year;
}

Personality::~Personality() {
    cout << "Personality is destroyed" << endl;
}
