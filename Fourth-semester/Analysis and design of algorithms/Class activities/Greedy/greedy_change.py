#Give change with the minimum amount of coins
from random import choice

def GreedyChange(coins, change):
    result = 0
    remaining = 0

    while remaining < change and coins:
        remaining = change
        high = max(coins)
        if (remaining // high) >= 0:
            remaining -= high * (remaining // high)
            result += (remaining // high)
            coins.pop(coins.index(high))
        else:
            coins.pop(coins.index(high))
    return result


denoms = [5, 2, 1, 0.5, 10]
coins = [choice(denoms) for _ in range(10)]

print(coins)
result = GreedyChange(coins, 13)
print(result)