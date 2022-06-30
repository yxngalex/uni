# Rešiti problem klasifikacije cifara prvo običnom ANN (ulaz su vrednosti svih piksela slike), a zatim i pomoću CNN.
# Uporediti rezultate (vreme treninga i tačnost na test skupu). Podaci su dostupni u okviru Keras biblioteke:
# https://keras.io/api/datasets/mnist/
# Jednostavna primena CNN sa vežbi je dostupna na linku:
# https://drive.google.com/file/d/1q03J1B8NSnfcNqSbtCMh_0eqlSENjnqz/view?usp=sharing
#
#
# Isključiti BatchNormalization() sloj, a zatim i per_image_standardization.

import numpy as np
import tensorflow as tf
from tensorflow import keras
from keras.models import Sequential
from keras.utils import to_categorical
from keras.layers import Flatten, Dense, Conv2D, Dropout, MaxPooling2D, BatchNormalization

# Loading data from mnist dataset
(x_train, y_train), (x_test, y_test) = keras.datasets.mnist.load_data()

x_train = x_train.reshape((x_train.shape[0], 28, 28, 1)).astype('float32')
x_test = x_test.reshape((x_test.shape[0], 28, 28, 1)).astype('float32')

x_train_norm = x_train / 255
x_test_norm = x_test / 255

y_train = to_categorical(y_train)
y_test = to_categorical(y_test)
num_classes = y_test.shape[1]

np.random.seed(42)
tf.random.set_seed(42)

model = Sequential()
model.add(Conv2D(30, (3, 3), input_shape=(28, 28, 1), activation='relu'))
# model.add(BatchNormalization())
model.add(MaxPooling2D())
model.add(Conv2D(15, (3, 3), activation='relu'))
# model.add(BatchNormalization())
model.add(MaxPooling2D())
model.add(Dropout(0.2))
model.add(Flatten())
model.add(Dense(128, activation='relu'))
model.add(Dense(50, activation='relu'))
model.add(Dense(num_classes, activation='softmax'))
model.compile(loss='categorical_crossentropy', optimizer="adam", metrics=['accuracy'])
model.summary()

num_epochs = 20

history = model.fit(x_train, y_train, epochs=num_epochs, batch_size=200)

model.evaluate(x_test, y_test, verbose=0)
