import sqlite3
from datetime import datetime
import pandas as pd


def main():
    conn = sqlite3.connect("biblioteka.db")
    cursor = conn.cursor()
    cursor = cursor.execute(
        "CREATE TABLE IF NOT EXISTS knjige ("
        "katBroj int,"
        "naslov varchar(64),"
        "izdavac varchar(64),"
        "godinaIzdavanja int,"
        "izdata boolean"
        ")"
    )

    add_book(conn)

    answ = input("Da li zelite da izdate neku knjigu? (Y/n): ")

    while True:
        if answ == "Y" or answ == "y":
            kat_broj = int(input("Unesite broj knjige koji želite da izdate: "))
            set_izdat(kat_broj, conn)
        elif answ == "n":
            break
        else:
            raise KeyboardInterrupt

    answ = input("Da li zelite da vidite sve knjige u bazi? (Y/n): ")

    while True:
        if answ == "Y" or answ == "y":
            find_all(conn)
        elif answ == "n":
            break
        else:
            raise KeyboardInterrupt


def add_book(conn) -> None:
    katBroj = int(input("Unesi katBroj: "))
    naslov = input("Unesi naslov: ")
    izdavac = input("Unesi izdavaca: ")
    godina_izadavnja = int(input("Unesi godinu izdavanja: "))
    current_year = datetime.now().year

    if godina_izadavnja > current_year:
        raise ValueError("Godina izdavanja je veća od trenutne godine")

    conn.cursor().execute("INSERT INTO knjige VALUES (?, ?, ?, ?, 0)",
                          (katBroj, naslov, izdavac, godina_izadavnja))

    conn.commit()


def set_izdat(kat_broj: int, conn) -> None:
    conn.cursor().execute("UPDATE knjiga SET izdata = 1 WHERE katBroj =: katBroj", {"katBroj": kat_broj})
    conn.commit()


def find_all(conn) -> None:
    df = pd.read_sql("SELECT * FROM knjige", con=conn)
    df.to_csv("izdate_knjige.csv", columns=("naslov", "izdavac", "godinaIzdavanja"))
    print(df)


if __name__ == '__main__':
    main()
