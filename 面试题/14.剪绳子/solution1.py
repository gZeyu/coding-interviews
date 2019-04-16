class Solution:
    def integerBreak(self, n):
        if n < 2:
            return 0
        elif n == 2:
            return 1
        elif n == 3:
            return 2
        products = [0] * (n + 1)
        products[0:5] = [0, 1, 2, 3, 4]
        return self.integerBreakCore(n, products)

    def integerBreakCore(self, n, products):
        for i in range(5, n + 1):
            for j in range(1, i // 2 + 1):
                tmp = products[j] * products[i - j]
                if tmp > products[i]:
                    products[i] = tmp
        return products[n]


s = Solution()
for n in range(11):
    print(n, s.integerBreak(n))