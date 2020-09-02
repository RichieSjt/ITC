n = float(input())
months = 4 + ((n-2018)*12)

years = months/12

print(years + 2018)
if years + 2018 >= n:
    print("yes")
else:
    print("no")
