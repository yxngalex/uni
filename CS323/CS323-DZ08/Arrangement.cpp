#include <iostream>
#include "Arrangement.h"

using namespace std;

Arrangement::Arrangement() {

}

Arrangement::Arrangement(string agency, string hotel, string p, int nights, int price) {
    this->nameOfAgency = agency;
    this->nameOfHotel = hotel;
    this->place = p;
    this->numOfNights = nights;
    this->arrangementPrice = price;
}

Arrangement::Arrangement(const Arrangement &a1) {
    this->nameOfAgency = a1.nameOfAgency;
    this->nameOfHotel = a1.nameOfHotel;
    this->place = a1.place;
    this->numOfNights = a1.numOfNights;
    this->arrangementPrice = a1.arrangementPrice;
}

Arrangement::~Arrangement() {
    cout << "Arrangement is destroyed" << endl;
}

void Arrangement::setNameOfAgency(string agency) {
    this->nameOfAgency = agency;

}

void Arrangement::setNameOfHotel(string hotel) {
    this->nameOfHotel = hotel;

}

void Arrangement::setPlace(string p) {
    this->place = p;

}

void Arrangement::setNumOfNights(int nights) {
    this->numOfNights = nights;

}

void Arrangement::setArragenmentPrice(int price) {
    this->arrangementPrice = price;

}

const string Arrangement::getNameOfAgency() {
    return this->nameOfAgency;
}

const string Arrangement::getNameOfHotel() {
    return this->nameOfHotel;
}

const string Arrangement::getPlace() {
    return this->place;
}

const int Arrangement::getNumOfNights() {
    return this->numOfNights;
}

const int Arrangement::getArragementPrice() {
    return this->arrangementPrice;
}
