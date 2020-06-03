from re import findall

def orientation(p, q, r):
    #cross product of vectors q-p and q-r
    x = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
    #Points are collinear
    if x == 0: 
        return 0
    #Clockwise orientation, negative area
    elif x > 0:
        return 1
    #Counter-clockwise orientation, positive area
    else:
        return 2

def left_most_index(points): 
    index = 0
    for i in range(1,len(points)): 
        if points[i][1] < points[index][1]: 
            index = i
        elif points[i][0] == points[index][0]: 
            if points[i][1] > points[index][1]: 
                index = i 
    return index 

#Convex hull using jarvis algorithm
def convex_hull(points, n):
    leftmost = left_most_index(points)
    p = leftmost
    q = 0
    solution = []

    while True:
        solution.append(points[p])
        q = (p + 1) % n

        for i in range(n):
            if orientation(points[p], points[i], points[q]) == 2:
                q = i
        p = q

        if p == leftmost:
            break
    return solution

n = int(input())
rectangles_points = []

for i in range(n):
    coordinates = input()
    #Regex to find all elements in between brackets
    points = findall(r'(?<=\().*?(?=\))', coordinates)
    p1x, p1y = map(int, points[0].split(","))
    p2x, p2y = map(int, points[1].split(","))

    #Upper left point, upper right point, lower right point, lower left point
    rectangles_points.append([p1x, p1y])
    rectangles_points.append([p2x, p1y])
    rectangles_points.append([p2x, p2y])
    rectangles_points.append([p1x, p2y])

result = convex_hull(rectangles_points, len(rectangles_points))
result.sort()

#Points that are part of the convex hull
for point in result:
    print('(' + str(point[0]) + ',' +  str(point[1]) + ')')