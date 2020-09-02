from re import findall

def maxAreaOfIsland(grid):
        global values,dicc
        seen = set()
        ans = 0
        for r0, row in enumerate(grid):
            for c0, val in enumerate(row):
                if val and (r0, c0) not in seen:
                    minPointRow = r0
                    minPointCol = c0
                    maxPointRow = r0
                    maxPointCol = c0
                    shape = 0
                    stack = [(r0, c0)]
                    seen.add((r0, c0))
                    while stack:
                        #print(stack)
                        r, c = stack.pop()
                        point = [(r,c)]
                        # si r y c mayores a maxPoint o menores que min
                        if r > maxPointRow:
                            maxPointRow = r
                        elif r < minPointRow:
                            minPointRow = r
                        elif c > maxPointCol:
                            maxPointCol = c
                        elif c < minPointCol:
                            minPointCol = c
                        #los reemplazas
                        shape += 1
                        for nr, nc in ((r-1, c), (r+1, c), (r, c-1), (r, c+1)):    
                            if (0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] and (nr, nc) not in seen):   
                                stack.append((nr, nc))
                                seen.add((nr, nc))
                    
                    dicc[shape] = [(minPointRow,minPointCol),(maxPointRow,maxPointCol)]
                    #values.append((minPoint,maxPoint)) 
                    ans = max(ans, shape)
                    
                    #guardar maxPoint y MinPoint asociado a un ans
        #regresas la tupla con mayor ans value 
        return dicc[ans]
    
n = input().split(' ')
board = []
values = []
dicc = {}
for i in range(int(n[0])):
    coordinates = input()
    points = findall(r'\d', coordinates)
   
    for i in range(0, len(points)):
        points[i] = int(points[i])
        
    board.append(points)
    
res = maxAreaOfIsland(board) 
#print(dicc)
print(res)