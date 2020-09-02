
def bfs(matrix, row, column, visited, counter):
    if(column > (len(matrix[0])-1) or column < 0 or row > (len(matrix)-1) or row < 0):
        return 0
    if [row, column] not in visited:
        if matrix[row][column] == 1:
            counter += 1
            #Up
            counter += bfs(matrix, row-1, column, visited, counter)
            #Down
            counter += bfs(matrix, row+1, column, visited, counter)
            #Right
            counter += bfs(matrix, row, column+1, visited, counter)
            #Left
            counter += bfs(matrix, row, column-1, visited, counter)

            visited.append([row, column])
            print(counter)
            return counter

        elif matrix[row][column] == 0:
            visited.append([row, column])
            bfs(matrix, row-1, column, visited, 0)
            #Down
            bfs(matrix, row+1, column, visited, 0)
            #Right
            bfs(matrix, row, column+1, visited, 0)
            #Left
            bfs(matrix, row, column-1, visited, 0)
    else:
        return 0

land_map = []
visited = []
row, column = map(int, input().split(" "))

for i in range(row):
    land_map.append([int(x) for x in input().split(" ")])

print(land_map)

bfs(land_map, 0, 0, visited, 0)
