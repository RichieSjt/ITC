n = input()

numbers = raw_input().split(" ")
nrange = raw_input().split(" ")

counter = 0

for n in numbers:
  if(int(n) >= int(nrange[0]) and int(n) <= int(nrange[1])):
    counter += 1
    
print(counter)