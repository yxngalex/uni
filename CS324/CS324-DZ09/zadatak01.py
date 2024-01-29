from matplotlib import pyplot as plt


def main():
    grades = []

    while True:
        grade = int(input("Uneti ocenu: "))
        if 5 < grade <= 10:
            grades.append(grade)
            print("Prosek: " + str(average(grades)))

        # Dodao sam 0 da bi mogao da izadje iz petlje
        if grade == 0:
            break

    plt.plot(range(len(grades)), average(grades), 'o', label='Ocene')
    plt.legend()
    plt.grid()
    plt.show()

    plt.pie(grades)
    plt.legend()
    plt.show()


def average(grades):
    return [sum(grades[0:x + 1]) / (x + 1) for x in range(len(grades))]


if __name__ == '__main__':
    main()
