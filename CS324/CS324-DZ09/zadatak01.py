from matplotlib import pyplot as plt


def main():
    grades = []

    while True:
        grade = int(input("Uneti ocenu: "))
        if 5 < grade <= 10:
            grades.append(grade)

        print("Prosek: " + str(average(grades)))

        if grade == 0:
            break

    plt.plot(range(1, len(grades) + 1), grades, 'o', label='Ocene')
    plt.plot(range(1, len(grades) + 1),
             average(grades), '>--', label='Prosek ocena')
    plt.legend()
    plt.grid()
    plt.show()

    # plt.pie(grades)
    # plt.legend()
    # plt.show()


def average(grades):
    s = 0
    for grade in grades:
        s += grade
    return s / len(grades)


if __name__ == '__main__':
    main()
