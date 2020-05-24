def combinations(n):
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

def evaluateExpresion(combinations, operands):
    expression = ""
    for i in range(len(combinations)):
        expression += combinations.pop(i)
        expression += operands.pop(i)

def boolEv(operands, n):
    if n == 1:
        res = 0
        r1 = evaluateExpresion([True])
        r2 = evaluateExpresion([False])
        if r1 == True:
            res += 1
        if r2 == True:
            res += 1
        return res
    if n > 1:
        evaluateExpresion(combinations(n), operands)
    else:
        return boolEv(operands[:n], n-1) * boolEv(operands[:n-1], n-2)

operands = []
expression = input("Enter the boolean expression: ")

for letter in expression:
    if(letter == "&"): 
        operands.append("and")
    elif(letter == "|"):
        operands.append("or")
combinations(1)

#result = boolEv(operands, len(operands))
#print(result)
