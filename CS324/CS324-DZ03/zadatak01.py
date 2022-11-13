def main():
    exams = {}

    num_of_exams = int(input("Unesite broj polozenih ispita: ").strip())
    for i in range(num_of_exams):
        exam = input("Unesite sifru {}. polozenog predmeta : ".format(i + 1)).strip().upper()
        grade = input("Unesite ocenu: ").strip()
        exams[exam] = grade

    q = input("Za koji predmet zelite da vidite detalje?: ").strip().upper()
    g = exams.get(q)

    if g is None:
        print("Niste polozili ispit {}".format(q))
    else:
        print("Polozili ste ispit {} sa ocenom {}".format(q, g))


if __name__ == '__main__':
    main()
