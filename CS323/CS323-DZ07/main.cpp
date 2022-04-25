#include <iostream>
#include "rectangle.h"

using namespace std;

/*
    Napisati program koji prikazuje površinu pravougaonika za
    proizvoljno unete podatke H i W (visina i širina). Uneti podatke za dva
    pravougaonika, ispitati koji ima veću površinu korišćenjem operatora ?, a
    zatim na ekranu ispisati odgovarajuću poruku
    (“Prvi ima veću površinu” ili “Drugi ima veću površinu”).
    Uraditi zadatak korišćenjem C++ klasa i modifikatora za ulaz/izlaz (cin, cout, setprecision, setwidth...).
*/

int main() {
    double h, w;
    Rectangle recOne;
    Rectangle recTwo;

    cout << "Please enter the height of a first rectangle";
    cin >> h;
    cout << "Please enter the width of a first rectangle";
    cin >> w;

    recOne.setW(w);
    recOne.setH(h);

    cout << "Please enter the height of a second rectangle";
    cin >> h;
    cout << "Please enter the width of a second rectangle";
    cin >> w;

    recTwo.setW(w);
    recTwo.setH(h);

    recOne.getArea() > recTwo.getArea() ? cout << "First has bigger area." : cout << "Second has bigger area";

    return 0;
}
