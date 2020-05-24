def print_table(table):
    for row in table:
        print(row)

def longest_dynamic(x, y):
    lenX = len(x) + 1
    lenY = len(y) + 1
    
    #Base cases
    table = [[None for columns in range(lenX)] for rows in range(lenY)]
    for i in range(lenX):
        table[0][i] = 0
    for i in range(lenY):
        table[i][0] = 0
    
    #Second string corresponds to rows
    for i in range(1, lenY):
    #First string corresponds to columns
        for j in range(1, lenX):
            #print(i, j)
            if x[j-1] == y[i-1]:
                table[i][j] = 1 + table[i-1][j-1]
            else:
                table[i][j] = max(table[i-1][j], table[i][j-1])
    #print_table(table)
    
    return table[lenY-1][lenX-1]

x, y = input().split()

print(longest_dynamic(x, y))