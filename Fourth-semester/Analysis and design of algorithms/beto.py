import random

dice = [random.randint(1, 6) for i in range(20)]
print(dice)
run = list()

counter = 1
max_counter = 0
max_index = 0

for i in range(len(dice)-1):
    if dice[i] == dice[i+1]:
        counter += 1
        #print(counter)
    else:
        counter = 1

    if counter > max_counter:
        max_counter = counter
        max_index = i - counter + 2

for i in range(len(dice)-1):
    if i == max_index:
        print("(", end=' ')
    if i == max_index + max_counter:
        print(")", end=' ')

    print(dice[i], end=' ')