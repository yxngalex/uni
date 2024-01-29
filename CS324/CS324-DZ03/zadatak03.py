import random


def main():
    index = 4173
    m = index // 3
    s = int(str(index)[0:2])
    e = int(str(index)[2:])

    data = dict((i, random.uniform(s, e)) for i, _ in enumerate(range(m)))
    print(list(data.items()))


if __name__ == "__main__":
    main()
