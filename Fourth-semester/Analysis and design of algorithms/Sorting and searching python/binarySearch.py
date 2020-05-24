def binarySearch(numbers, number_to_search):
    start = 0
    end = len(numbers)-1

    while start <= end:
        mid = (start + end) // 2
        if numbers[mid] == number_to_search:
            return mid
        elif numbers[mid] < number_to_search:
            start = mid + 1
        else:
            end = mid - 1
    return -1

sorted_list = [3, 8, 14, 16, 25, 28, 30, 33, 40, 69, 80, 89, 96, 100]

print("Sorted list:", sorted_list)

number_to_search = int(input("Enter the number to search: "))

print(binarySearch(sorted_list, number_to_search))
