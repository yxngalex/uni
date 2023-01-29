from predmet import Predmet
from student import Student
from datetime import date


def main():
    lista = list()
    s = Student("Aleksa", "Cekic")
    s.set_broj_indeksa(4173)
    s.set_smer("Softversko inzenjerstvo")
    d = date(2019, 8, 9)
    s.set_godina_upisa(d)

    num = int(input("Koliko polozenih ispita zelite? > "))

    for n in range(num):
        lista.append(s.dodaj_polozen_ispit(s))

    s.set_polozeni_ispiti(lista)

    print(s.prvi_ispit())
    print(s.najbolji_ispit())


if __name__ == '__main__':
    main()
