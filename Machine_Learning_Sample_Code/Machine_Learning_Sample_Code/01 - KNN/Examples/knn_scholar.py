import pandas as pd
from sklearn.neighbors import KNeighborsClassifier

# Loading scholars data as dataframe
df = pd.read_csv('scholar.csv')
print("Scholar.csv Dataframe:")
print(df)

# Training set: first 10 instances
df_train = df.head(10)

X = df_train[['Sibs','Income','Grade']].values
y = df_train['Approve']
print("\n\nTraining Set: First 10 instances:")
print(df_train)

# Test set: last 4 instances
df_test = df.tail(4)
samples = df_test[['Sibs','Income','Grade']].values

print("\n\nTest Set: Last 4 instances:")
print(df_test)

# Instatiate KNN models (k=1 and k=3) and train models using fit() function
knn1 = KNeighborsClassifier(n_neighbors=1)
knn1.fit(X, y)
knn3 = KNeighborsClassifier(n_neighbors=3)
knn3.fit(X, y)


# Generate predicted labels using trained models
knn1_prediction = knn1.predict(samples)
knn3_prediction = knn3.predict(samples)

# display results
df_test_display = df_test.copy()
df_test_display["knn1"] = knn1_prediction
df_test_display["knn3"] = knn3_prediction
print(df_test_display)