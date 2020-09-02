def share_candies(bags, n, total_candies):
    candies = total_candies // 2
    table = [[None for column in range(candies+1)] for row in range(n+1)]
    if total_candies % 2 != 0:
        return False
    else:
        for row in range(n):
            table[row][0] = True
        for column in range(1, candies+1):
            table[0][column] = False
        for i in range(1, n+1):
            for j in range(1, candies+1):
                if (bags[i-1] > j):
                    table[i][j] = table[i-1][j]
                else:
                    table[i][j] = (table[i-1][j-bags[i-1]] or table[i-1][j])
    return table[n][candies]

n = int(input())
bags = [int(x) for x in input().split(' ')]

print(share_candies(bags, n, sum(bags)))