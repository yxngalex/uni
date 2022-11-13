import random


def student(name: str, index: int):
    if len(name) % 2 == 0:
        rand_nums = [random.randint(0, index) for _ in range(index)]
    else:
        rand_nums = [random.uniform(-int(str(index)[:2]), int(str(index)[2:])) for _ in range(index)]
    rand_nums.sort()

    return rand_nums


def main():
    print(student("Aleksa", 4173))


if __name__ == "__main__":
    main()
