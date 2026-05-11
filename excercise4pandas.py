import pandas as pd



def task_1_series_creation():
    buildings = {
        "Gillet": 4,
        "Carman": 3,
        "Music": 3,
        "Library": 4
    }

    series_buildings = pd.Series(buildings)
    print(series_buildings)


def task_2_dataframe_creation():
    data = {
        "CourseCode": ["CMP168", "CMP269", "CMP338"],
        "Credits": [4, 4, 4],
        "Enrolled": [25, 30, 20]
    }

    df_courses = pd.DataFrame(data)
    print(df_courses)


def task_3_data_manipulation():
    data = {
        "CourseCode": ["CMP168", "CMP269", "CMP338"],
        "Credits": [4, 4, 4],
        "Enrolled": [25, 30, 20]
    }

    df = pd.DataFrame(data)

    filtered = df[df["Enrolled"] > 20]
    print("Courses with more than 20 students:")
    print(filtered)

    total_students = df["Enrolled"].sum()
    print("\nTotal students across all courses:", total_students)


def task_4_csv_integration():
    stock_data = {
        "Symbol": ["AAPL", "MSFT", "GOOG"],
        "Price": [185.12, 420.55, 132.77]
    }

    df_stocks = pd.DataFrame(stock_data)

    df_stocks.to_csv("stocks.csv", index=False)

    df_loaded = pd.read_csv("stocks.csv")
    print(df_loaded)


if __name__ == "__main__":
    task_1_series_creation()
    task_2_dataframe_creation()
    task_3_data_manipulation()
    task_4_csv_integration()
