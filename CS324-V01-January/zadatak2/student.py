from osoba import Osoba
from predmet import Predmet
from datetime import datetime, date


class Student(Osoba):
    def __init__(self, ime, prezime):
        super().__init__(ime, prezime)
        self.broj_indeksa = 0
        self.smer = ""
        self.godina_upisa = None
        self.polozeni_ispiti = []

    def set_ime(self, ime):
        self.ime = ime

    def set_prezime(self, prezime):
        self.prezime = prezime

    def set_broj_indeksa(self, broj_indeksa):
        self.broj_indeksa = broj_indeksa

    def set_smer(self, smer):
        self.smer = smer

    def set_godina_upisa(self, godina_upisa):
        self.godina_upisa = godina_upisa

    def set_polozeni_ispiti(self, polozeni_ispiti):
        self.polozeni_ispiti = polozeni_ispiti

    def get_ime(self):
        return self.ime

    def get_prezime(self):
        return self.prezime

    def get_broj_indeksa(self):
        return self.broj_indeksa

    def get_smer(self):
        return self.smer

    def get_godina_upisa(self):
        return self.godina_upisa

    def get_polozeni_ispiti(self):
        return self.polozeni_ispiti

    def __repr__(self):
        return f"{self.ime}, {self.prezime}, {self.smer}, {self.godina_upisa}"

    @staticmethod
    def dodaj_polozen_ispit(self):
        polozeni_ispiti = list()
        today = date.today()
        while True:
            try:
                sifra = input("Unesi sifru predmeta: ")
                naziv = input("Unesi naziv predmeta: ")

                ocena = int(input("Unesi ocenu"))

                if 6 <= ocena <= 10:
                    print("Unesi datum polaganja:")
                    godina = int(input("Unesi godinu: "))
                    mesec = int(input("Unesi mesec: "))
                    dan = int(input("Unesi dan: "))
                    unet_datum = date(godina, mesec, dan)
                    d = unet_datum.strftime("%MM-%YY")
                    p = Predmet(sifra, naziv, ocena, d)

                    if self.godina_upisa <= today >= unet_datum:
                        polozeni_ispiti.append(p)
                    else:
                        print("Datum je neispravan")
                        exit()
                    return polozeni_ispiti
                else:
                    print("Ocena mora da bude veca od 6 do 10")
            except ValueError:
                print("Pogresan unos")
                exit()

    def prvi_ispit(self):
        for i in range(len(self.polozeni_ispiti)):
            if min(self.polozeni_ispiti[i][i].datum_polaganja):
                return "Student: " + self.ime + "\n" \
                       + "Ispit: " + self.polozeni_ispiti[i][i].sifra + " " + self.polozeni_ispiti[i][i].naziv + "\n " \
                       + "Ocena: " + self.polozeni_ispiti[i][i].ocena + "\n" \
                       + "Datum: " + self.polozeni_ispiti[i][i].datum_polaganja + ""

    def najbolji_ispit(self):
        for i in range(len(self.polozeni_ispiti)):
            if max(self.polozeni_ispiti[i][i].ocena):
                return "Student: " + self.ime + "\n" \
                       + "Ispit: " + self.polozeni_ispiti[i][i].sifra + " " + self.polozeni_ispiti[i][i].naziv + "\n " \
                       + "Ocena: " + self.polozeni_ispiti[i][i].ocena + "\n" \
                       + "Datum: " + self.polozeni_ispiti[i].datum_polaganja + ""
