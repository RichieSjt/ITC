#Think about the basic case.
#Let's x and y be the two strings

#if x[0] == y[0] then the result is 1 + f(x[1:], y[1:])
#else the result is max(f(x[1:], y), f(x, y[1:]))

def longest_subsequence(x, y):
    if not x or not y:
        return 0
    else:
        if x[0] == y[0]:
            return 1 + longest_subsequence(x[1:], y[1:])
        else:
            return max(longest_subsequence(x[1:], y), longest_subsequence(x, y[1:]))

x, y = input().split()

print(longest_subsequence(x, y))

