n = int(input())
points = []

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

for i in range(3):
    px, py = map(float, input().split(" "))
    points.append([px, py])
area = determinant(shoelace_matrix(points[0], points[1], points[2]))/2
print(str(area) + '0')