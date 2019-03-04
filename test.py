def cal(n, X, A):
    sum_of_diff = sum(A) - n * X
    diff = [X - A[i] for i in range(len(A))]
    diff = sorted(diff)
    diff.reverse()
    s = 0
    count = 0
    for i in diff:
        s = s + i
        count = count + 1
        if (s+sum_of_diff >= 0):
            break
    return count
if __name__ == '__main__':
    print(cal(5,60,[59,20,30,90,100]))