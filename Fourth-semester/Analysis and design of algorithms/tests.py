#word = "Bruh"
#print(word[1:])

#print(17%10)
#print(7%8)

#Traverse matrix diagonaly
i = 0
x = 3
stop = x
while(i < x):
    if(stop == i):
        break
    for j in range(3):
        print(i, j)
        i += 1
    print("End of cycle")
    x += 1
    i -= 2