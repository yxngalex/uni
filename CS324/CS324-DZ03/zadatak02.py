import random


def main():
    student_index = [random.randint(1, 10000) for _ in range(5)]
    student_index.sort(reverse=True)
    print(student_index)


if __name__ == "__main__":
    main()
