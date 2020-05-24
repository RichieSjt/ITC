def fill(pixels, row, column, colorToReplace, replacementColor):
    if(column > (len(pixels[0])-1) or column < 0 or row > (len(pixels)-1) or row < 0):
        return
    if(pixels[row][column] == replacementColor):
        return
    elif(pixels[row][column] != colorToReplace):
        return
    elif(pixels[row][column] == colorToReplace):
        pixels[row][column] = replacementColor
    
    #Up
    fill(pixels, row-1, column, colorToReplace, replacementColor)
    #Down
    fill(pixels, row+1, column, colorToReplace, replacementColor)
    #Right
    fill(pixels, row, column+1, colorToReplace, replacementColor)
    #Left
    fill(pixels, row, column-1, colorToReplace, replacementColor)

    

pixels = [[1, 1, 1, 1, 1, 1],
          [1, 0, 0, 0, 0, 1],
          [1, 0, 0, 0 ,1, 0],
          [1, 1, 1, 1, 0, 0]]

print("Before fill \n")
for row in pixels:
    print(*row)

fill(pixels, 1, 1, pixels[1][1], 2)

print("\nAfter fill \n")
for row in pixels:
    print(*row)

