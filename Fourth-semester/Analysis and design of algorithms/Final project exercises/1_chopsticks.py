from re import findall

def determinant(matrix):
    a = (matrix[0][0] * matrix[1][1] * matrix[2][2]) + (matrix[1][0] * matrix[2][1] * matrix[3][2]) + (matrix[2][0] * matrix[3][1] * matrix[4][2])
    b = (matrix[0][2] * matrix[1][1] * matrix[2][0]) + (matrix[1][2] * matrix[2][1] * matrix[3][0]) + (matrix[2][2] * matrix[3][1] * matrix[4][0])
    return a - b

def shoelace_matrix(point1, point2, point3):
    matrix = [
                [point1[0], point2[0], point3[0]], 
                [point1[1], point2[1], point3[1]], 
                [1, 1, 1],
                [point1[0], point2[0], point3[0]], 
                [point1[1], point2[1], point3[1]]
             ]
    return matrix

def shoelace(line1, line2):
    #Clockwise returns negative area
    #Counter-clockwise returns positive area
    #Checking 
    determinant1 = determinant(shoelace_matrix(line1[0], line1[1], line2[0]))
    determinant2 = determinant(shoelace_matrix(line1[0], line1[1], line2[1]))

    #print(determinant1, determinant2)

    #If one determinant is negative and the other one is positive it is possible that the lines intersect
    if (determinant1 < 0 and determinant2 > 0) or (determinant1 > 0 and determinant2 < 0):
        return True
    #If one determinant is 0 but the other isn't, then they intersect in one point
    elif (determinant1 == 0 and determinant2 != 0) or (determinant2 == 0 and determinant1 != 0):
        return True
    #If both determinants are 0 then the lines are the same
    elif(determinant1 == 0 and determinant2 != 0):
        return True
    else:
        return False

def check_intersection(line1, line2):
    #We need to check both ways of creating triangles with the lines
    #If both checks return true then we are sure they intersect
    return shoelace(line1, line2) and shoelace(line2, line1)

def chopsticks(lines, n):
    intersects = False
    chopsticks_num = 0
    #Check every single stick with the others
    for i in range(n):
        for j in range(n):
            if i == j:
                pass
            else:
                intersects |= check_intersection(lines[i], lines[j])
        #If the stick does not intersects with any other stick then add 1 to the counter
        if not intersects:
            chopsticks_num += 1
        intersects = False
    return chopsticks_num

n = int(input())
lines = []

for i in range(n):
    coordinates = input()
    #Regex to find all elements in between brackets
    points = findall(r'(?<=\().*?(?=\))', coordinates)
    p1x, p1y = map(int, points[0].split(","))
    p2x, p2y = map(int, points[1].split(","))
    lines.append([[p1x, p1y], [p2x, p2y]])

print(chopsticks(lines, n))