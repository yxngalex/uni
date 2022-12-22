import sqlite3


class Clazz:
    def __init__(self, code, full_name, professor, academic_year) -> None:
        super().__init__()
        self.academic_year = academic_year
        self.professor = professor
        self.full_name = full_name
        self.code = code

    def __repr__(self):
        return "{} {} {} {}".format(self.code, self.full_name, self.professor, self.academic_year)


def main():
    conn = sqlite3.connect(":memory:")
    cursor = conn.cursor()
    ddl = """
        CREATE TABLE IF NOT EXISTS predmeti (
            sifra varchar(16) PRIMARY KEY,
            punoIme varchar(64) NOT NULL,
            profesor varchar(64) NOT NULL,
            godinaStudiranja int NOT NULL
        );
    """

    cursor.execute(ddl)

    cs324 = Clazz("CS324", "Skripting jezici", "Milos Milasinovic", 4)
    it381 = Clazz("IT381", "Zaštita i bezbednost informacija", "Bogdan Bogdanovic", 4)
    cs322 = Clazz("CS322", "Programiranje u C#", "Milos Milasinovic", 4)
    om350 = Clazz("OM350", "Preduzetništvo", "Marko Markovic", 4)

    dml(cs324, cursor)
    dml(it381, cursor)
    dml(cs322, cursor)
    dml(om350, cursor)

    courses = find_all_by_prof("Milos Milasinovic", cursor)
    for course in courses:
        print(course)

    conn.close()


def dml(clazz, cursor):
    cursor.execute("INSERT INTO predmeti values (?, ?, ?, ?)",
                   (clazz.code, clazz.full_name, clazz.professor, clazz.academic_year))


def find_all_by_prof(prof, cursor):
    cursor.execute("SELECT * FROM predmeti WHERE profesor = :professor", {
        "professor": prof
    })
    return cursor.fetchall()


if __name__ == '__main__':
    main()
