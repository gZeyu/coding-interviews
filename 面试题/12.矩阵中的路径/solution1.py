# -*- coding:utf-8 -*-
class Solution:
    def hasPath(self, matrix, rows, cols, path):
        visited = [False] * (rows * cols)
        for row in range(rows):
            for col in range(cols):
                if self.hasPathCore(matrix, rows, cols, row, col, path,
                                    visited) == True:
                    return True
        return False

    def hasPathCore(self, matrix, rows, cols, row, col, path, visited):
        if len(path) == 0:
            return True
        if row < 0 or row >= rows or col < 0 or col >= cols or visited[
                row * cols + col] == True:  # constrant
            return False
        if matrix[row * cols + col] != path[0]:  # bound
            return False
        visited[row * cols + col] = True
        if self.hasPathCore(matrix, rows, cols, row-1, col, path[1:], visited) \
            or self.hasPathCore(matrix, rows, cols, row+1, col, path[1:], visited) \
            or self.hasPathCore(matrix, rows, cols, row, col-1, path[1:], visited) \
            or self.hasPathCore(matrix, rows, cols, row, col + 1, path[1:], visited):
            return True
        else:
            visited[row * cols + col] = False
            return False
