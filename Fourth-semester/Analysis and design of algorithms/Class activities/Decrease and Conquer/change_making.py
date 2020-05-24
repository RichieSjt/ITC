def change_making(denoms, change, n):
    if change == 0:
        return 0
    elif n < 0:
        return 10000000
    else:
        return min(change_making(denoms, change%denoms[n], n-1) + change//denoms[n],
                   change_making(denoms, change, n-1))

denoms = [1, 2, 8, 10]
change = 17
answer = change_making(denoms, change, len(denoms)-1)
print(answer)
