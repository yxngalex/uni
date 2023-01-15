import numpy as np
import pandas as pd


def main():
    # arrays
    a1 = np.random.randint(5, 11, 500)
    a2 = np.random.randint(5, 11, 500)
    a3 = np.random.randint(5, 11, 500)
    a4 = np.random.randint(16, size=500)
    a5 = np.random.randint(2, size=500)
    a6 = np.random.randint(5, 11, 500)

    for i in range(500):
        if (a1[i] in range(8, 11) or a2[i] in range(9, 11)) and a5[i] < 10:
            a5[i] += 1
        if a3[i] in range(5, 13) and a5[i] > 5:
            a5[i] -= 1
        if a3[i] in range(13, 16) and a5[i] > 6:
            a5[i] -= 2
        if a4[i] == 0:
            a5[i] = 5

    df = pd.DataFrame(
        {"cs_101_ocena": a1, "it_101_ocena": a2, "ma_101_ocena": a3, "cs_115_izostanci": a4, "cs_115_polozen": a5,
         "cs_115_ocena": a6})

    df.to_csv("dataset.csv", index=False)


if __name__ == '__main__':
    main()
