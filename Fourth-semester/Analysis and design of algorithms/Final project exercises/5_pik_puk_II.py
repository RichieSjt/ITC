n = int(input())
bags = [int(x) for x in input().split(' ')]

bags.sort(reverse = True)

pik = 0
puk = 0

for quantity in bags:
    if pik < puk:
        pik += quantity
    else:
        puk += quantity

print(pik == puk)