#include "rectangle.h"

Rectangle::Rectangle() {

}

Rectangle::Rectangle(double width, double height) {
    w = width;
    h = height;
}

double Rectangle::getArea() const {
    return w * h;
}


