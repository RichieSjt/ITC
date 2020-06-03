n = int(input())
bags = []

for i in range(n):
    bags.append(int(input()))

bags.sort(reverse = True)

pik = 0
puk = 0

for quantity in bags:
    if pik < puk:
        pik += quantity
    else:
        puk += quantity

print(pik == puk)