import pandas as pd
import numpy as np
from matplotlib import pyplot as plt
from collections import Counter


def main():
    data = pd.read_csv("data.csv")

    print("1: {}".format(round(np.mean(data["Trajanje"]), 3)))
    print("2: {}".format(round(data.groupby(["NivoStudija"])["Trajanje"].mean(), 3)))
    print("3:")
    print(data.groupby(["StudijskiProgram"])["Trajanje"].value_counts())
    print("4:")
    print(data.groupby(["Univerzitet"])["Trajanje"].value_counts())

    # 5
    duration = data["Trajanje"].to_list()
    mean = np.mean(duration)

    plt.axvline(mean, color="red")
    plt.hist(duration, edgecolor="black", linewidth=1.5)
    plt.title("5: Broj studenata po trajanju studija: ")
    plt.xlabel("Trajanje studija")
    plt.ylabel("Broj studenata")

    plt.show()

    # 6
    university = data["Univerzitet"].to_list()
    plt.hist(university, edgecolor="black", linewidth=1.0)
    plt.xticks(rotation=10)
    plt.title("6: Broj studenata po univerzitetima")
    plt.ylabel("Broj studenata")
    plt.xlabel("Univerziteti")

    plt.show()

    # 7
    major_counter = Counter(data["StudijskiProgram"])
    plt.pie(major_counter.values(), labels=major_counter.keys(), startangle=40, autopct="%.1f%%",
            wedgeprops={"edgecolor": "white", "linewidth": 1})
    plt.title("6: Raspodela studenata po studijskim programima")

    plt.show()

    university_counter = Counter(data["Univerzitet"])
    plt.pie(university_counter.values(), labels=university_counter.keys(), autopct="%.1f%%",
            wedgeprops={"edgecolor": "white", "linewidth": 1})
    plt.title("6: Raspodela studenata po univerzitetu")

    plt.show()


if __name__ == '__main__':
    main()
