#include <iostream>
#include "Lekar.h"
#include <vector>
#include <iterator>
#include <fstream>
#include <stack>
#include <algorithm>

int main() {
    Lekar l1, l2, l3, l4, l5, l6, O1;

    l1.setIme("Jovan");
    l1.setPrezime("Jovanovic");
    l1.setAdresa("Nis");
    l1.setTelefon("06412345123");
    l1.setGodiste("1954");
    l1.setDatumRodj("7 Jun");
    l1.setImeZavrsenogFakulteta("Metropolitan");

    l2.setIme("Petar");
    l2.setPrezime("Peric");
    l2.setAdresa("Nis");
    l2.setTelefon("06443123453");
    l2.setGodiste("2003");
    l2.setDatumRodj("17 Januar");
    l2.setImeZavrsenogFakulteta("Metropolitan");

    l3.setIme("Marko");
    l3.setPrezime("Markovic");
    l3.setAdresa("Nis");
    l3.setTelefon("06409302123");
    l3.setGodiste("1999");
    l3.setDatumRodj("8 Avgust");
    l3.setImeZavrsenogFakulteta("Elektronski Fakultet");

    l4.setIme("Marko");
    l4.setPrezime("Markovic");
    l4.setAdresa("Nis");
    l4.setTelefon("06409302123");
    l4.setGodiste("1999");
    l4.setDatumRodj("8 Avgust");
    l4.setImeZavrsenogFakulteta("Prirodno Matematicki");

    l5.setIme("Stefan");
    l5.setPrezime("Stefanovic");
    l5.setAdresa("Nis");
    l5.setTelefon("06912345678");
    l5.setGodiste("1999");
    l5.setDatumRodj("15 Septembar");
    l5.setImeZavrsenogFakulteta("Elektronski Fakultet");

    l6.setIme("Aleksa");
    l6.setPrezime("Cekic");
    l6.setAdresa("Nis");
    l6.setTelefon("06488585883");
    l6.setGodiste("1999");
    l6.setDatumRodj("15 Avgust");
    l6.setImeZavrsenogFakulteta("Elektronski Fakultet");

    vector<Lekar> v = {l1, l2, l3, l4, l5};
    v.insert(v.begin() + 2, l6);
    v.pop_back();
    vector<Lekar>::iterator it = v.begin();

    while (it != v.end()) {
        (*it).info();
        it++;
    }

    cout << endl;

    l5.setIme("Novi");
    l5.setPrezime("Objekat");
    l5.setAdresa("Nis");
    l5.setTelefon("06312347272");
    l5.setGodiste("2002");
    l5.setDatumRodj("25 Novembar");
    l5.setImeZavrsenogFakulteta("Univerzitet Metropolitan");

    it = find(v.begin(), v.end(), O1);
    if (it != v.end()) {
        cout << "Objekat je pronadjen" << endl;
    } else {
        cout << "Objekat nije pronadjen" << endl;
    }

    cout << endl;

    int n;
    stack<Lekar> st;

    cout << "Unesite broj elemenata za upis lekara u stek" << endl;
    cin >> n;

    for (int i = 0; i < n; i++) {
        Lekar l;
        string s;

        cout << "\nUnesite ime lekara: ";
        cin >> s;
        l.setIme(s);
        cout << "Unesite prezime lekara: ";
        cin >> s;
        l.setPrezime(s);
        cout << "Unesite adresu lekara: ";
        cin >> s;
        l.setAdresa(s);
        cout << "Unesite telefon lekara: ";
        cin >> s;
        l.setTelefon(s);
        cout << "Unesite godiste lekara: ";
        cin >> s;
        l.setGodiste(s);
        cout << "Unesite datum rodjenja lekara: ";
        cin >> s;
        l.setDatumRodj(s);
        cout << "Unesite ime zavrsenog fakulteta lekara: ";
        cin >> s;
        l.setImeZavrsenogFakulteta(s);

        st.push(l);
    }

    cout << "Stampa se inverzno stek:" << endl;

    while (!st.empty()) {
        cout << "Stek: " << st.top() << endl;
        st.pop();
    }

    return 0;
}
