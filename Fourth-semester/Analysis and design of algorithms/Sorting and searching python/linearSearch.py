import random

def generate_random_list(list_size):
    random_list = []
    for i in range(list_size):
        random_list.append(random.randrange(1, 100))
    return random_list


def linearSearch(numbers, number_to_search):
    for number in numbers:
        if number == number_to_search:
            return numbers.index(number)
    return -1

list_size = int(input("Enter the size of the list: "))
numbers = generate_random_list(list_size)

print("Generated list:", numbers)

number_to_search = int(input("Enter the number to search: "))
print(linearSearch(numbers, number_to_search))