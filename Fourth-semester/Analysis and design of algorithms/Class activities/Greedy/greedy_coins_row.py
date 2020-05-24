from random import choice

def coinRowGreedy(coins):
    total = 0
    while coins:
        high = max(coins)
        total += high
        high_index = coins.index(high)

        if high_index > 0:
            left = coins[:high_index - 1]
        else:
            left = []
        if high_index < len(coins) - 1:
            right = coins[high_index + 2:]
        else:
            right = []
        print("\t", left, right)
        coins = left + right
    return total

denoms = [5, 2, 1, 0.5, 0.2, 0.1]
n = 10
coins = [choice(denoms) for _ in range(n)]
print(coins)

res = coinRowGreedy(coins)
print(res)
