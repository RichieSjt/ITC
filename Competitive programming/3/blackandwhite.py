n = int(input())
grid = [[0 for i in range(n)] for j in range(n)]

black_count = 0
white_count = 0
consecutive_count = 1
possible = False

for i in range(n):
    for index, char in enumerate(input()):
        grid[i][index] = char

        if char == 'W':
            white_count += 1
        else:
            black_count += 1

    #Row check
    if white_count != black_count:
        possible = False
    else:
        possible = True

    white_count = 0
    black_count = 0

if possible:
    #Column check
    for i in range(n):
        for j in range(n):
            if grid[j][i] == 'W':
                white_count += 1
            else:
                black_count += 1
            
            #Consecutive numbers check
            if i < n and j < n-1:

                if grid[j][i] == grid[j+1][i]:
                    consecutive_count += 1
                else:
                    consecutive_count = 1

                if consecutive_count >= 3:
                    possible = False
    
        #Same number of squares check
        if possible:
            if white_count != black_count:
                possible = False
            else:
                possible = True

        white_count = 0
        black_count = 0
        consecutive_count = 1

if possible:
    #Row check
    for i in range(n):
        for j in range(n):
            #Consecutive numbers check
            if i < n and j < n-1:
                if grid[i][j] == grid[i][j+1]:
                    consecutive_count += 1
                else:
                    consecutive_count = 1
        
                if consecutive_count >= 3:
                    possible = False 
        
        #Same number of squares check
        if possible:
            if white_count != black_count:
                possible = False
            else:
                possible = True

        white_count = 0
        black_count = 0
        consecutive_count = 1

if possible:
    print("1")
else:
    print("0")