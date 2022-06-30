# Rešiti problem klasifikacije cifara prvo običnom ANN (ulaz su vrednosti svih piksela slike), a zatim i pomoću CNN.
# Uporediti rezultate (vreme treninga i tačnost na test skupu). Podaci su dostupni u okviru Keras biblioteke:
# https://keras.io/api/datasets/mnist/
# Jednostavna primena CNN sa vežbi je dostupna na linku:
# https://drive.google.com/file/d/1q03J1B8NSnfcNqSbtCMh_0eqlSENjnqz/view?usp=sharing

import numpy as np
import tensorflow as tf
from tensorflow import keras
from keras.models import Sequential
from keras.layers import Flatten
from keras.layers import Dense

# Loading data from mnist dataset
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

# Data Normalization so that we get the values 0 or 1
x_train_norm = x_train / 255
x_test_norm = x_test / 255

# Crating a validation to verify the improvement of the model
x_validation, x_train = x_train_norm[:5000], x_train_norm[5000:]
y_validation, y_train = y_train[:5000], y_train[5000:]

x_test = x_test_norm

np.random.seed(42)
tf.random.set_seed(42)

model = Sequential()
model.add(Flatten(input_shape=[28, 28]))
model.add(Dense(300, activation="relu"))
model.add(Dense(100, activation="relu"))
model.add(Dense(10, activation="softmax"))

model.summary()

model.compile(loss="sparse_categorical_crossentropy",
              optimizer="sgd",
              metrics=["accuracy"])

num_epochs = 20

history = model.fit(x_train, y_train, epochs=num_epochs)

model.evaluate(x_test, y_test)
