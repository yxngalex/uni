#pragma once

#include <iostream>

using namespace std;

class Rectangle {
private:
    double w;
    double h;

public:
    Rectangle();

    Rectangle(double width, double height);

    void setW(double width) {
        w = width;
    }

    double getW() {
        return w;
    }

    void setH(double height) {
        h = height;
    }

    double getH() {
        return h;
    }

    double getArea() const;

};
