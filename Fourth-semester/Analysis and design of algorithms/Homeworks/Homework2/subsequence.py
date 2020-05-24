def check(seq1, seq2):
    counter = 0
    max_sequence = 0
    i = 0
    j = 0
    prevj = -1

    while i < len(seq1) + 1:
        j = prevj + 1
        #print("iteration:",i)
        if j == len(seq2) and seq2 or i >= len(seq1): 
            #print("Counter", counter)
            max_sequence = counter if counter > max_sequence else max_sequence
            seq2 = seq2[1:]
            i = 0
            j = 0
            prevj = -1
            counter = 0
            #print("End of check, new string:", seq2)
            if not seq2: break
        while j < len(seq2):
            #print("seq1:", seq1[i], "seq2:", seq2[j])
            if seq1[i] == seq2[j]:
                prevj = j
                counter += 1
                break
            j += 1
        i += 1
    return max_sequence

seq1, seq2 = input().split()

print(max(check(seq1, seq2), check(seq2, seq1)))