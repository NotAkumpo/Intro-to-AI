import pandas as pd
from sklearn.datasets import load_iris
# KNN
from sklearn.neighbors import KNeighborsClassifier
from matplotlib import pyplot as plt
from sklearn.metrics import confusion_matrix

# Load Iris Dataset into a DataFrame
iris = load_iris()
iris_df = pd.DataFrame(data=iris.data,
                       columns=iris.feature_names)
print("Loading Iris DataFrame:")
print(iris_df)


# Split into train (75%) and test set(25%) with random sampling
iris_train_df = iris_df.sample(frac = 0.75)
iris_train_y = iris.target[iris_train_df.index]
print("\n\nTraining Set Sample:")
print(iris_train_df.head())

iris_test_df = iris_df.drop(iris_train_df.index)
iris_test_y = iris.target[iris_test_df.index]
print("\n\nTest Set Sample:")
print(iris_test_df.head())

# Create and Train KNN models (k=1 and k=3)
knn1 = KNeighborsClassifier(n_neighbors=1)
knn1.fit(iris_train_df, iris_train_y)
knn3 = KNeighborsClassifier(n_neighbors=3)
knn3.fit(iris_train_df, iris_train_y)

# Generate predictions by the models
knn1_prediction = knn1.predict(iris_test_df)
knn3_prediction = knn3.predict(iris_test_df)


# Get the accuracy and confusion matrix of each model
acc1 = knn1.score(iris_test_df, iris_test_y)
acc3 = knn3.score(iris_test_df, iris_test_y)

cm1 = confusion_matrix(iris_test_y,knn1_prediction)
cm3 = confusion_matrix(iris_test_y,knn3_prediction)

print("\n\nResults\n")
print("kNN, k = 1 accuracy:",acc1)
print(cm1)

print("kNN, k = 3 accuracy:",acc3)
print(cm3)