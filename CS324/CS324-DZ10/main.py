from matplotlib import pyplot as plt
import pandas as pd
from collections import Counter


def main():
    input_data()
    data = pd.read_csv("Student_izvestaj.csv")

    counted = Counter(data["Ocena"])

    grades = []
    num_grades = []
    avg_grades = []
    figure = plt.figure()
    counter = 0
    suma = 0

    for num in data["Ocena"]:
        suma += num
        counter += 1
        avg_grades.append(suma / counter)

    courses = data["Predmet"].copy()
    for c in range(len(courses)):
        courses[c] = courses[c][:2]

    grade_counter = Counter(courses)

    for grade, number in counted.items():
        num_grades.append(number)
        grades.append(grade)

    figure_1 = figure.add_subplot(2, 2, 1)
    figure_1.pie(num_grades, labels=grades, autopct="%.1f%%", startangle=60,
                 wedgeprops={"edgecolor": "white", "linewidth": 2})

    figure_2 = figure.add_subplot(2, 2, 2)
    plt.barh(list(grade_counter.keys()), list(grade_counter.values()))
    plt.ylabel("Ocena")
    plt.xlabel("Broj ocena")

    figure_3 = figure.add_subplot(2, 2, (3, 4))
    plt.plot(range(len(data["Ocena"])), avg_grades, "g-", label="Prosek")
    plt.plot(range(len(data["Ocena"])), data["Ocena"], "ro", label="Ocena")

    plt.savefig("Student_izvestaj.png")
    plt.show()


def input_data():
    courses = []
    while True:
        q = input("Dodaj novi polozeni ispit? (Y/n): ")
        if q == 'y' or q == 'Y':
            course = input("Unesite sifru predmeta: ")
            grade = int(input("Unesite ocenu: "))
            if 5 < grade <= 10:
                courses.append({"Predmet": course, "Ocena": grade})
            else:
                print("Ocena mora biti veca od 4 i manja od 11")
                continue

        elif q == 'n':
            break
        else:
            raise KeyboardInterrupt
    df = pd.DataFrame.from_dict(courses)
    print(df)
    df.to_csv("Student_izvestaj.csv")


if __name__ == '__main__':
    main()
