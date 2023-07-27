import matplotlib.pyplot as plt

# Financial data for June in each year
years = ['2020', '2021', '2022', '2023']
june_sales = [151, 181, 240, 268]
june_profit = [76, 91, 74, 95]

# Plotting the data
plt.figure(figsize=(8, 5))
plt.plot(years, june_sales, marker='o', label='June Sales')
plt.plot(years, june_profit, marker='o', label='June Profit')
plt.xlabel('Years')
plt.ylabel('Amount (INR million)')
plt.title('June Sales and Profit Trend')
plt.legend()
plt.grid(True)
plt.tight_layout()

# Show the chart
plt.show()
