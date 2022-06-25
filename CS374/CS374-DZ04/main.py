"""
    1. Podeliti podatke na trening i test skup, izvršiti klasifikaciju pomoću k-NN algoritma i prikazati tačnost.
    2. Prikazati tačnost za različite vrednosti parametra k. Testirati za 3, 5, 7 i 9, a u slučaju da tačnost raste,
     možete probati i za veće vrednosti. Diskutovati rezultate.
    3. Pokrenuti težinsku varijantu (težine zavise od udaljenosti) i proveriti da li se tačnost menja i kako.
    4. Eksprimentisati sa nekom od sledećih tehnika po vašem izboru i prikazati kako se menja tačnost klasifikacije:
     Promena metrike rastojanja, izbor nekog podskupa atributa prilikom klasifikacije (umesto da se koriste svi atributi)
      ili primena bagging-a (https://en.wikipedia.org/wiki/Bootstrap_aggregating).
"""

import pandas as pd
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier

# Getting data for iphone purchase records
df = pd.read_csv('../../../input/iphone_purchase_records.csv')

df.head()

df = df.drop('Gender', axis=1)

X = df.drop('Purchase Iphone', axis=1)
Y = df['Purchase Iphone']

X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=.25, random_state=100)

col_name = X.columns

sc = StandardScaler()

X_train = sc.fit_transform(X_train)
X_test = sc.fit_transform(X_test)

X_train = pd.DataFrame(X_train, columns=col_name)
X_test = pd.DataFrame(X_test, columns=col_name)

k_value = [3, 5, 7, 9]


def KNN(X_train, X_test, Y_train, Y_test, k_val):
    for n in k_val:
        knn = KNeighborsClassifier(n_neighbors=n, metric='minkowski', p=2)
        knn.fit(X_train, Y_train)
        Y_pred = knn.predict(X_test)
        accuracy = accuracy_score(Y_pred, Y_test)
        print("Accuracy for k = " + str(n) + ": " + str(accuracy))

        # added metric distance
        knn = KNeighborsClassifier(n_neighbors=n, metric='minkowski', p=2, weights='distance')
        knn.fit(X_train, Y_train)
        Y_pred = knn.predict(X_test)
        accuracy = accuracy_score(Y_pred, Y_test)
        print("Accuracy with changed metric distance for k = " + str(n) + ": " + str(accuracy))

        # changed metric to chebyshev
        knn = KNeighborsClassifier(n_neighbors=n, metric='chebyshev', p=2)
        knn.fit(X_train, Y_train)
        Y_pred = knn.predict(X_test)
        accuracy = accuracy_score(Y_pred, Y_test)
        print("Accuracy with chebyshev metric for k = " + str(n) + ": " + str(accuracy) + "\n")


KNN(X_train, X_test, Y_train, Y_test, k_value)
