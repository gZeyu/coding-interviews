class Solution:
    def integerBreak(self, n):
        if n < 2:
            return 0
        elif n == 2:
            return 1
        elif n == 3:
            return 2
        number_of_3 = n // 3
        r = n % 3
        if r == 0:
            return 3**number_of_3
        elif r == 1:
            return 3**(number_of_3 - 1) * 4
        else:
            return 3**number_of_3 * 2


s = Solution()
for n in range(11):
    s.integerBreak(n)