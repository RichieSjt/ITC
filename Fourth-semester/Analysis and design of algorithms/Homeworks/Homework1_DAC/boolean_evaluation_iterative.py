def booleanComb(n):
    totalCombinations = []
    for i in range(2**n):
        booleanComb = []
        binaryNum = bin(i)[2:].zfill(n)
        for digit in binaryNum:
            if(digit == "1"):
                booleanComb.append(True)
            else:
                booleanComb.append(False)
        totalCombinations.append(booleanComb)
    return totalCombinations

    
operands = []
expression = input("Enter the boolean expression: ")

for letter in expression:
    if(letter == "&"): 
        operands.append("and")
    elif(letter == "|"):
        operands.append("or")

combinations = booleanComb(len(operands) + 1)

res = 0
expressionToEvaluate = ""

for combination in combinations:
    for i in range(0, len(combination)):
        expressionToEvaluate += str(combination[i]) + " "
        if(i < len(combination)-1):
            expressionToEvaluate += operands[i] + " "
    if(eval(expressionToEvaluate)):
        res += 1
    expressionToEvaluate = ""

print(res)