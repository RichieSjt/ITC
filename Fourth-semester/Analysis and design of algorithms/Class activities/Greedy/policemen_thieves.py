def policemenAndThieves(pt, k):
    n = len(pt)
    police = 0
    thief = 0
    catches = 0

    for i in range(n):
        while pt[police] != 'P':
            police += 1
        while pt[thief] != 'T':
            thief += 1
        if abs(police-thief) <= k:
            catches += 1
    return catches

pt = ['P', 'T' 'P', 'T', 'T', 'P']
k = 3

result = policemenAndThieves(pt, k)
print(result)
