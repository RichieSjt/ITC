heights = list()
widths = list()

n, m, v_rectangles, h_rectangles = map(int, input().split())

checker_board = [[0 for i in range(m)] for j in range(n)]

for i in range(v_rectangles):
    heights.append(int(input()))
for i in range(h_rectangles):
    widths.append(int(input()))

tabla = ""
for height in range(len(heights)):
    caracter = "B" if height%2 == 0 else "W"
    for i in range(heights[height]):
        for width in widths:
            for j in range(width):
                tabla += caracter
            caracter = "B" if caracter == "W" else "W"
        tabla += "\n"

print(tabla)