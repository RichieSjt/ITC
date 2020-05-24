import random

def generate_random_list(list_size):
    random_list = []
    for i in range(list_size):
        random_list.append(random.randrange(1, 100))
    return random_list

def selectionSort(numbers):
    for i in range(len(numbers)-1):
        idx_smallest = i
        for j in range(i + 1, len(numbers)):
            if numbers[j] < numbers[idx_smallest]:
                idx_smallest = j
        #Swap
        numbers[idx_smallest], numbers[i] = numbers[i], numbers[idx_smallest]

    return numbers

list_size = int(input("Enter the size of the list: "))

numbers = generate_random_list(list_size)

print("List before sort:", numbers)
print("List after sort:", selectionSort(numbers))