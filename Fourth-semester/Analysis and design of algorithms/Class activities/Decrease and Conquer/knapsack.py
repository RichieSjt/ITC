def knapsack(values, weights, capacity, n):
    if(n < 0 or capacity == 0):
        return 0
    if capacity < weights[n]:
        return knapsack(values, weights, capacity, n-1)

    #If we pick the item we diminish the capacity and continue to the next element
    res1 = knapsack(values, weights, capacity-weights[n], n-1) + values[n]
    #If we do not pick the item we only continue to the next element
    res2 = knapsack(values, weights, capacity, n-1)
    
    return max(res1, res2)

values = [12, 10, 20, 15]
weights = [2, 1, 3, 2]
capacity = 5
maxvalue = knapsack(values, weights, capacity, len(values)-1)
print(maxvalue)
