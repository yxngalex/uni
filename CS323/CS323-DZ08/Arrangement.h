#include <string>

using namespace std;


class Arrangement {
private:
    string nameOfAgency;
    string nameOfHotel;
    string place;
    int numOfNights;
    int arrangementPrice;
public:
    Arrangement();

    Arrangement(string agency, string hotel, string p, int nights, int price);

    Arrangement(const Arrangement &a1);

    ~Arrangement();

    void setNameOfAgency(string agency);

    void setNameOfHotel(string hotel);

    void setPlace(string p);

    void setNumOfNights(int nights);

    void setArragenmentPrice(int price);

    const string getNameOfAgency();

    const string getNameOfHotel();

    const string getPlace();

    const int getNumOfNights();

    const int getArragementPrice();
};
