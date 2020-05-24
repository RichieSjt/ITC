def fibo(n):
    if n == 0 or n == 1:
        return 1
    else:
        return fibo(n-1) + fibo(n-2)

def fiboMemoization(n, table):
    if table[n] == None:
        table[n] = fiboMemoization(n-1, table) + fiboMemoization(n-2, table)
    
    return table[n]

def fiboTabulation(n):
    table = [None for x in range(n+1)]
    table[0] = 1
    table[1] = 1
    for i in range(2, n+1):
        table[i] = table[i-1] + table[i-2]

    return table[n]

n = 69
table = [None for x in range(n+1)]
table[0] = 1
table[1] = 1
res = fiboMemoization(n, table)
print(res, table)
