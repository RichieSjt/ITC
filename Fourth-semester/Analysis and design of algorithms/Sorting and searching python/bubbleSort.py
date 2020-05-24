import random

def generate_random_list(list_size):
    random_list = []
    for i in range(list_size):
        random_list.append(random.randrange(1, 100))
    return random_list

def bubbleSort(numbers):
    for i in range(len(numbers)-1):
        for j in range(len(numbers)-1):
            if numbers[j] > numbers[j+1]:
                #Swap the numbers
                numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

    return numbers

list_size = int(input("Enter the size of the list: "))

numbers = generate_random_list(list_size)

print("List before sort:", numbers)
print("List after sort:", bubbleSort(numbers))