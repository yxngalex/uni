import numpy as np
import pandas as pd
from matplotlib import pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split


def estimated_values(X, y, percent, col_name):
    X_train, X_test, y_train, y_test = train_test_split(X, y, train_size=percent)
    model = LinearRegression()
    model.fit(X_train, y_train)

    pred = model.predict(X_test)

    new_df = pd.DataFrame(X_test, columns=[col_name])
    new_df['Y'] = y_test
    new_df['Prediction'] = pred

    accuracy = model.score(X_test, y_test)
    print(accuracy)

    plt.scatter(new_df[col_name], y_test, color='red')
    plt.plot(new_df[col_name], pred, color='blue')
    plt.show()


def main():
    df = pd.read_csv("dataset.csv")
    data = ["cs_101_ocena", "cs_115_ocena"]
    extracted = df[data]
    pred = "cs_115_ocena"

    X = np.array(extracted.drop([pred], 1))
    y = np.array(df[pred])

    estimated_values(X, y, 0.75, "cs_101_ocena")
    estimated_values(X, y, 0.90, "cs_101_ocena")

    data = ["cs_115_izostanci", "cs_115_ocena"]
    extracted = df[data]
    pred = "cs_115_ocena"

    X = np.array(extracted.drop([pred], 1))
    y = np.array(df[pred])

    estimated_values(X, y, 0.75, "cs_115_izostanci")
    estimated_values(X, y, 0.90, "cs_115_izostanci")

    data = ["cs_101_ocena", "it_101_ocena",
            "ma_101_ocena", "cs_115_izostanci", "cs_115_ocena"]
    extracted = df[data]

    X = np.array(extracted.drop([pred], 1))
    y = np.array(df[pred])

    X_train, X_test, y_train, y_test = train_test_split(X, y, train_size=0.75)

    model = LinearRegression()
    model.fit(X_train, y_train)

    pred = model.predict(X_test)
    accuracy = model.score(X_test, y_test)
    errors = np.sum(np.where(y_test != pred))
    print(accuracy, " ", errors)

    X_train, X_test, y_train, y_test = train_test_split(X, y, train_size=0.90)

    model = LinearRegression()
    model.fit(X_train, y_train)

    pred = model.predict(X_test)
    accuracy = model.score(X_test, y_test)
    errors = np.sum(np.where(y_test != pred))
    print(accuracy, " ", errors)


if __name__ == '__main__':
    main()
