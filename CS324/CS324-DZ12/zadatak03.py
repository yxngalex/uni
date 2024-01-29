import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from matplotlib import pyplot as plt


def regression(X, y, percent):
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=percent, random_state=0)

    model = LogisticRegression()
    model.fit(X_train, y_train)

    pred = model.predict(X_test)

    new_df = pd.DataFrame(X_test)
    new_df["Data"] = X_test
    new_df["Predicted"] = pred

    errors = np.sum(np.where(y_test != pred, 1, 0))
    print(pred)
    print("Number of errors -> {}".format(errors))

    plt.scatter(new_df["Data"], y_test, color='red')
    plt.plot(new_df["Data"], pred, color='blue')
    plt.show()


def main():
    df = pd.read_csv("dataset.csv")

    # 1
    X = df[["cs_101_ocena"]]
    y = df["cs_115_polozen"]

    regression(X, y, 0.25)
    regression(X, y, 0.1)

    # 2
    X = df[["cs_115_izostanci"]]
    y = df["cs_115_polozen"]

    regression(X, y, 0.25)
    regression(X, y, 0.1)

    # 3
    X = df[["cs_101_ocena", "it_101_ocena", "ma_101_ocena", "cs_115_izostanci"]]
    y = df["cs_115_polozen"]

    regression(X, y, 0.25)
    regression(X, y, 0.1)


if __name__ == '__main__':
    main()
