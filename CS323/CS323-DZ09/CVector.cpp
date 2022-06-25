#include "CVector.h"
#include <iostream>

using namespace std;

CVector::CVector() {

}

CVector::CVector(int x, int y, int z) {
    this->x = x;
    this->y = y;
    this->z = z;
}

CVector::CVector(const CVector &c1) {
    this->x = c1.x;
    this->y = c1.y;
    this->z = c1.z;
}

CVector::~CVector() {
    cout << "CVector is deleted" << endl;
}

int CVector::getX() const {
    return x;
}

void CVector::setX(int x) {
    CVector::x = x;
}

int CVector::getY() const {
    return y;
}

void CVector::setY(int y) {
    CVector::y = y;
}

int CVector::getZ() const {
    return z;
}

void CVector::setZ(int z) {
    CVector::z = z;
}

CVector CVector::operator+(const CVector &c) {
    CVector res;
    res.x = this->x + c.x;
    res.y = this->y + c.y;
    res.z = this->z + c.z;

    return res;
}

CVector operator-(const CVector &c1, const CVector &c2) {
    CVector res;
    res.x = c1.x - c2.x;
    res.y = c1.y - c2.y;
    res.z = c1.z - c2.z;

    return res;
}

void CVector::scalarSum(const CVector &c1, const CVector &c2) {
    // TODO: Implement logic
}

void CVector::vectorLenght(const CVector &c) {
    // TODO: Implement logic
}

void CVector::izracunajKosinusUglaVektora(const CVector &c) {
    // TODO: Implement logic
}


