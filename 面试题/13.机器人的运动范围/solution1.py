# -*- coding:utf-8 -*-
class Solution:
    def movingCount(self, threshold, rows, cols):
        visited = [False] * (rows * cols)
        return self.movingCountCore(threshold, rows, cols, 0, 0, visited)

    def movingCountCore(self, threshold, rows, cols, row, col, visited):

        if row < 0 or row >= rows or col < 0 or col >= cols or visited[
                row * cols + col] == True:
            return 0
        if self.getDigitSum(row) + self.getDigitSum(col) > threshold:
            return 0
        visited[row * cols + col] = True
        return 1 + self.movingCountCore(threshold, rows, cols, row + 1, col, visited) \
            + self.movingCountCore(threshold, rows, cols, row - 1, col, visited) \
            + self.movingCountCore(threshold, rows, cols, row, col + 1, visited) \
            + self.movingCountCore(threshold, rows, cols, row, col - 1, visited)

    def getDigitSum(self, num):
        sum = 0
        while (num != 0):
            sum = sum + num % 10
            num = num // 10
        return sum


s = Solution()
print(s.getDigitSum(123))