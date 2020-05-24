def tiles(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    else:
        horizontal = tiles(n-2)
        vertical = tiles(n-1)
        return horizontal + vertical

for i in range (1, 10):
    result = tiles(i)
    print(i, result)