def pok(numbers, desired_sum, x):
    
    #If the desired sum is equal to 0 then that means we found a way to decrease it
    #exactly to 0 using the given numbers
    if desired_sum == 0:
        return True

    #If we ran out of numbers and couldn´t find a solution then there is no answer
    if x < 0 and desired_sum != 0:
        return False

    #If the number is greater than the desired sum we ignore it
    if numbers[x] > desired_sum:
        return pok(numbers, desired_sum, x-1)
    
    #Ignoring the number or using it
    return pok(numbers, desired_sum, x-1) or pok(numbers, desired_sum-numbers[x], x-1)

x = int(input())

numbers = []
for i in range(x):
    numbers.append(int(input()))

desired_sum = int(input())

print(pok(numbers, desired_sum, x-1))