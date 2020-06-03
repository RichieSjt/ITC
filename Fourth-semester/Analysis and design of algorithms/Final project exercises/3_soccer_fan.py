from operator import itemgetter

n = int(input())
shirts = []

for i in range(n):
    team, nationality = input(), input()
    shirt = {'team': team, 'nationality': nationality}
    shirts.append(shirt)

for x in sorted(shirts, key = itemgetter('nationality', 'team')):
    print(x.get('team'))