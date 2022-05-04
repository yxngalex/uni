#include <string>

using namespace std;


class Personality {
private:
    string name;
    string address;
    int day;
    string month;
    string year;
public:
    Personality();

    Personality(string name, string address, int day, string month, string year);

    Personality(const Personality &p1);

    ~Personality();

    const string &getName() const;

    void setName(const string &name);

    const string &getAddress() const;

    void setAddress(const string &address);

    const int &getDay() const;

    void setDay(const int &day);

    const string &getMonth() const;

    void setMonth(const string &month);

    const string &getYear() const;

    void setYear(const string &year);

};
