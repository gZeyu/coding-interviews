import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
                s.printMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } })
                        .toString());
        System.out.println(s.printMatrix(new int[][] { { 1 } }).toString());
        return;
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> out = new ArrayList<>();
        if (matrix == null) {
            return out;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] v = { 0, 1 };
        int curX = 0;
        int curY = 0;
        boolean[][] visited = new boolean[row + 1][col + 1];
        while (curX >= 0 && curX < row && curY >= 0 && curY < col && !visited[curX][curY]) {
            out.add(matrix[curX][curY]);
            visited[curX][curY] = true;
            int nextX = curX + v[0];
            int nextY = curY + v[1];
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY]) {
                rotate90(v);
            }
            curX += v[0];
            curY += v[1];
        }
        return out;
    }

    public void rotate90(int[] v) {
        int tmp = v[0];
        v[0] = v[1];
        v[1] = -tmp;
    }
}
