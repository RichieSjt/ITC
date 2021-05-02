test_cases = int(input())
res = sym = let = ""

for _ in range(test_cases):
    expression = input()

    for c in expression:
        if c == '+' or c == '-' or c == '*' or c == '/' or c == '^':
            sym += c
        elif ord(c) >= 97 and ord(c) <= 122:
            let += c
        elif c ==')':
            res += f"{let}{sym[-1]}"
            sym = sym[:-1]
            let = ""

    res += sym
    print(res)
    res = ""