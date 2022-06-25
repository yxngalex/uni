#pragma once

#include <iostream>

using namespace std;

class CVector {
private:
    int x;
    int y;
    int z;
public:
    CVector();

    CVector(int x, int y, int z);

    CVector(const CVector &c1);

    ~CVector();

    int getX() const;

    void setX(int x);

    int getY() const;

    void setY(int y);

    int getZ() const;

    void setZ(int z);

    CVector operator+(const CVector &c);

    friend CVector operator-(const CVector &c1, const CVector &c2);

    void scalarSum(const CVector &c1, const CVector &c2);

    void vectorLenght(const CVector &c);

    void izracunajKosinusUglaVektora(const CVector &c);
};

