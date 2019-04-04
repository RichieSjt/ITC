n = 1
while n != 0
    n = int(input())
    if n != 0
        vals = {}
        for i in range(2,n+1):
            while n%i == 0:
                n = n//i
                if i in vals:
                    vals[i] += 1
                else:
                    vals[i] = 1
            if n == 1:
                break

        print(vals)
        res = 1
        for v in vals:
            if vals[v] == 1:
                res *= v-1
            else:
                res *= (v-1) * pow(v,vals[v]-1)
        print(res)
