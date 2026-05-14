# CMP 269: Programming Methods III
# In-Class Assignment: Stock Data Analysis

import pandas as pd
import numpy as np

def get_messy_market_data():
    """Helper function providing the raw data for today's lab."""
    return pd.DataFrame({
        "Date": ["Mon", "Tue", "Wed", "Thu", "Fri"],
        "Open": [200.0, 202.5, np.nan, 201.0, 205.0],
        "Close": [203.0, np.nan, 199.0, 204.5, 208.0],
        "Volume": [1500000, 1800000, 1200000, np.nan, 2100000]
    })

def task_1_data_cleaning():
    df = get_messy_market_data()

    print("Missing values per column:")
    print(df.isna().sum())

    df["Volume"].fillna(0, inplace=True)
    df.dropna(subset=["Open", "Close"], inplace=True)

    print("\nCleaned DataFrame:")
    print(df)
    return df


def task_2_volatility_filtering(clean_df):
    clean_df["Price_Swing"] = clean_df["Close"] - clean_df["Open"]

    volatile_days = clean_df[(clean_df["Price_Swing"] > 2.0) | (clean_df["Price_Swing"] < -2.0)]

    print("Days with high volatility:")
    print(volatile_days)


def task_3_financial_summary(clean_df):
    print("Close column statistics:")
    print(clean_df["Close"].describe())

    max_volume = clean_df["Volume"].max()
    print("\nMaximum Volume for the week:", max_volume)


def task_4_algorithmic_metrics(clean_df):
    clean_df["Daily_Return"] = clean_df["Close"].pct_change()
    clean_df["2_Day_MA"] = clean_df["Close"].rolling(window=2).mean()

    print(clean_df)


if __name__ == "__main__":
    clean_df = task_1_data_cleaning()

    if clean_df is not None:
        task_2_volatility_filtering(clean_df.copy())
        task_3_financial_summary(clean_df.copy())
        task_4_algorithmic_metrics(clean_df.copy())
