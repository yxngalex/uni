def fibonacci_recursion(n: int):
    if n <= 1:
        return n
    return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2)


def fibonacci_ite(n: int):
    a, b = 0, 1
    for i in range(0, n):
        a, b = b, a + b
    return a


def main():
    print("FIBONACCI SEQUENCE\n")

    print("Recursion: \n")
    for i in range(10):
        print(fibonacci_recursion(i), end=", ")

    print("\n")

    print("Iteration: \n")
    for i in range(10):
        print(fibonacci_ite(i), end=", ")


if __name__ == "__main__":
    main()
