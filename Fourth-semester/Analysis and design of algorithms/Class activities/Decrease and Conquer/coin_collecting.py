def coinCollect(board, x, y, maxX, maxY):
    if(x > maxX or y > maxY):
        return 0

    move_right = coinCollect(board, x+1, y, maxX, maxY) + board[x][y]
    move_down = coinCollect(board, x, y+1, maxX, maxY) + board[x][y]

    return(max(move_right, move_down))

board = [[0,0,0,0,1,0], [0,1,0,1,0,0], [0,0,0,1,0,1], [0,0,1,0,0,1]]
x = 0
y = 0
maxX = len(board) - 1
maxY = len(board[0]) - 1
result = coinCollect(board, x, y, maxX, maxY)
print(result)