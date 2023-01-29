from abc import ABC, abstractmethod


# Abstraktna klasa
class Osoba(ABC):
    def __init__(self, ime, prezime):
        self.ime = ime
        self.prezime = prezime

    @abstractmethod
    def set_ime(self, ime):
        self.ime = ime

    @abstractmethod
    def set_prezime(self, prezime):
        self.prezime = prezime

    @abstractmethod
    def get_ime(self):
        return self.ime

    @abstractmethod
    def get_prezime(self):
        return self.prezime
