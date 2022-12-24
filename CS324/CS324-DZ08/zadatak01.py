import numpy as np


def main():
    # Prva matrica
    m1 = np.identity(3)
    print(m1)

    # Druga matrica
    m2 = np.zeros((4, 4))
    m2_inner = np.full((2, 2), 10)
    m2[1:-1, 1:-1] = m2_inner
    print(m2)

    # Treca matrica
    m3 = np.ones((5, 5))
    m3_inner = np.zeros((3, 3))
    m3_inner[1, 1] = 1
    m3[1:-1, 1:-1] = m3_inner
    print(m3)


if __name__ == '__main__':
    main()
