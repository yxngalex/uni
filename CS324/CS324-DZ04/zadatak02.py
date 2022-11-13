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


# Sličnosti su u tome što je rezultat potpuno isti.
# Razlike između ova dva pristupa za prikaz fibonačijevog niza jesu u tome što kod rekurzivnog pristupa kod je manji i
# čitljiviji, ali zato zauzima više memorije i vremena procesora zbog čestih poziva funkcija nego kod iterativnog
# pristupa.

if __name__ == "__main__":
    main()
