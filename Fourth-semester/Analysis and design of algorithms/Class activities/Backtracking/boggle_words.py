def enEspera(word, board, row, column):
    
    #print("Checking ", word[0], " at ", row, column)
    
    if(column > (len(board[0])-1) or column < 0 or row > (len(board)-1) or row < 0):
        return

    if word[0] != board[row][column]:
        return
    
    length = len(word)
    
    if length == 1 and word == board[row][column]:
        #print("word found")
        return True
    elif length > 1:
        if enEspera(word[1:], board, row-1, column-1): return True
        if enEspera(word[1:], board, row-1, column): return True
        if enEspera(word[1:], board, row-1, column+1): return True
        if enEspera(word[1:], board, row, column+1): return True
        if enEspera(word[1:], board, row+1, column+1): return True
        if enEspera(word[1:], board, row+1, column): return True
        if enEspera(word[1:], board, row+1, column-1): return True
        if enEspera(word[1:], board, row, column-1): return True
    else:
        return False
    
#Determine if we can build the word from the location
def isValid(word, board):
    length = len(board)
    for i in range(length):
        for j in range(length):
            if word[0] == board[i][j]:
                return enEspera(word, board, i, j)
    
    return False

def countWords(words, board):
    count = 0
    for word in words:
        if isValid(word, board):
            count += 1
    return count

####################
words = ["GEEKS", "FOR", "QUIZ", "GO"]
board = [["G","I","Z"],
         ["U","E","K"],
         ["Q","S","E"]]
res = countWords(words, board)
print(res)