def coin_row(coins, n):
    if n < 0 :
        return 0
    if n == 0:
        return coins[0]
    else:
        return max(coin_row(coins, n-2) + coins[n], coin_row(coins, n-1))

coins = [1, 2, 0.2, 0.5, 0.1, 0.2, 0.1, 0.5, 0.2, 0.2]
answer = coin_row(coins, len(coins)-1)
print(answer)