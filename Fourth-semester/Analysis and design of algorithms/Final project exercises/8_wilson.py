def bfs(matrix, row, column):
    if(column > (len(matrix[0])-1) or column < 0 or row > (len(matrix)-1) or row < 0):
        return
    if matrix[row][column] == 1:
        return 1
    elif matrix[row][column] == 0:
        return
    
    #Up
    bfs(matrix, row-1, column)
    #Down
    bfs(matrix, row+1, column)
    #Right
    bfs(matrix, row, column+1)
    #Left
    bfs(matrix, row, column-1)

land_map = []
row, column = map(int, input().split(" "))

for i in range(row):
    land_map.append([int(x) for x in input().split(" ")])

print(bfs(land_map, 0, 0))
