def print_table(table):
    for row in table:
        print(row)

def pok_dynamic(numbers, desired_sum):
    numbers_len = len(numbers) + 1
    #Base cases
    table = [[None for columns in range(numbers_len)] for rows in range(desired_sum + 1)]

    #Decreasing the desired number to 0 successfully
    for i in range(numbers_len):
        #columns
        table[0][i] = True
    #Runing out of coins and desired sum is diferent from 0
    for i in range(1, desired_sum + 1):
        #rows
        table[i][0] = False

    for i in range(1, desired_sum + 1):
        for j in range(1, numbers_len):
            #print(i, j)
            if i < numbers[j-1]:
                table[i][j] = table[i][j-1]
            if i >= numbers[j-1]:
                #Ignoring the number or using it
                table[i][j] = table[i][j-1] or table[i-numbers[j-1]][j-1]

    #print_table(table)
    return table[desired_sum][numbers_len-1]

x = int(input())

numbers = []
for i in range(x):
    numbers.append(int(input()))

desired_sum = int(input())

print(pok_dynamic(numbers, desired_sum))