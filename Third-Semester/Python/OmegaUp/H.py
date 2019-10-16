n = int(input())

numbers = input().split(" ")

r = input().split(" ")

print(r[0])

counter = 0
for i in range(0, n-1):
    if(r[0] < numbers[i]):
        counter+=1