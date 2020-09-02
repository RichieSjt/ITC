n = int(input())

if n%2 != 0:
    print("Either")
if n%2 == 0:
    if n%4 == 0:
        print("Even")
    else:
        print("Odd")