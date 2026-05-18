import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

"""
INSTRUCTIONS:
Part A: Complete the visualization tasks to analyze a mock financial dataset.
Part B: Write testable logic and Pytest assertions to verify your financial math.
"""

# PART A: VISUALIZATION

def get_crypto_data():
    """Helper function to load mock crypto data."""
    return pd.DataFrame({
        "Day": [1, 2, 3, 4, 5, 6, 7],
        "Bitcoin": [40000, 42000, 41000, 45000, 44000, 46000, 48000],
        "Ethereum": [2500, 2600, 2550, 2800, 2750, 2900, 3100]
    })


def task_1_trend_line():
    """
    TASK 1: Matplotlib Line Chart
    1. Load the data using get_crypto_data().
    2. Use plt.plot() to chart Bitcoin prices over the 7 days.
    3. Add a title, x-axis label, and y-axis label.
    4. Call plt.show() to render it.
    """
    print("--- Task 1: Building a Trend Line ---")
    df = get_crypto_data()

    plt.plot(df["Day"], df["Bitcoin"], marker="o", color="orange", linewidth=2)
    plt.title("Bitcoin Price Trend Over 7 Days")
    plt.xlabel("Day")
    plt.ylabel("Price (USD)")
    plt.grid(True)
    plt.show()


def task_2_seaborn_comparison():
    """
    TASK 2: Seaborn Bar Chart
    1. Create a simple DataFrame mapping 3 portfolios to their Total Value.
    2. Use sns.barplot() to display the comparison.
    3. Call plt.show() to render it.
    """
    print("--- Task 2: Seaborn Comparison ---")
    df = pd.DataFrame({
        "Portfolio": ["Portfolio A", "Portfolio B", "Portfolio C"],
        "Total Value": [10000, 15000, 8000]
    })

    sns.barplot(x="Portfolio", y="Total Value", data=df, palette="viridis")
    plt.title("Portfolio Value Comparison")
    plt.xlabel("Portfolio")
    plt.ylabel("Total Value ($)")
    plt.show()

# PART B

def calculate_growth(start_value, end_value):
    """Return percent growth between two values."""
    return ((end_value - start_value) / start_value) * 100

def calculate_average(values):
    """Return the average of a list of numeric values."""
    return sum(values) / len(values)

def test_calculate_growth():
    assert round(calculate_growth(100, 120), 2) == 20.00
    assert round(calculate_growth(50, 75), 2) == 50.00

def test_calculate_average():
    assert calculate_average([10, 20, 30]) == 20
    assert calculate_average([100, 200, 300, 400]) == 250


if __name__ == "__main__":
    task_1_trend_line()
    task_2_seaborn_comparison()
    pass
