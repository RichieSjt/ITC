n = int(input())
a = list()
ans = True

for _ in range(n):
    nint = input()
    a = [int(x) for x in input().split()]
    a.sort()

    for i in range(len(a)-1):
        if(abs(a[i+1] - a[i]) > 1):
            ans = False
    print("YES") if ans else print("NO")
    ans = True