def frog(stones):
    if stones < 1 :
        return 0
    if stones == 1:
        return 1
    else:
        one_jump = frog(stones-1)
        two_jump = frog(stones-2)
        return one_jump + two_jump

stones = 5
answer = frog(stones)
print(answer)


