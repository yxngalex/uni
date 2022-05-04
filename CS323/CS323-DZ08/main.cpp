#include <iostream>
#include "Arrangement.h"
#include "Personality.h"


void getZodiac(Personality p[]) {
    for (int i = 0; i < 4; ++i) {
        if (p->getMonth() == "January") {
            if (p->getDay() >= 20) {
                cout << p->getName() << " je vodolija." << endl;
            }
        } else if (p->getMonth() == "February") {
            if (p->getDay() <= 18) {
                cout << p->getName() << endl;
            }
        }
    }
}

int main() {

    cout << "Problem 27" << endl;

    Arrangement a1;

    a1.setNameOfAgency("Test");
    a1.setNameOfHotel("Test");
    a1.setPlace("Test");
    a1.setNumOfNights(5);
    a1.setArragenmentPrice(1234);

    cout << "Printing Arrangement" << endl;

    cout << a1.getNameOfAgency() << " " << a1.getNameOfHotel() << " " << a1.getPlace() << " " << a1.getNumOfNights()
         << " " << a1.getArragementPrice() << " " << endl;


    cout << "Problem 4" << endl;

    Personality p1, p2, p3, p4;

    p1.setName("Sara");
    p1.setAddress("Nis");
    p1.setDay(15);
    p1.setMonth("February");
    p1.setYear("1998");

    p2.setName("Marko");
    p2.setAddress("Beograd");
    p2.setDay(5);
    p2.setMonth("January");
    p2.setYear("2003");

    p3.setName("Igor");
    p3.setAddress("Novi Sad");
    p3.setDay(13);
    p3.setMonth("March");
    p3.setYear("2000");

    p4.setName("Aleksa");
    p4.setAddress("Nis");
    p4.setDay(14);
    p4.setMonth("July");
    p4.setYear("1999");

    Personality array[5];

    array[0] = p1;
    array[1] = p2;
    array[2] = p3;
    array[3] = p4;


    getZodiac(array);

    return 0;
}
