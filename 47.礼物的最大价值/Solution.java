public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
    System.out.println(s.minPathSum(new int[][] { { 1, 3, 1 } }));
    System.out.println(s.minPathSum(new int[][] { { 1 }, { 1 }, { 1 } }));
    System.out.println(s.minPathSum(new int[][] {}));
    System.out.println(s.minPathSum(null));
  }

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return 0;
    int row = grid.length;
    int col = grid[0].length;
    int[][] dp = new int[row][col];
    dp[row - 1][col - 1] = grid[row - 1][col - 1];
    for (int i = row - 2; i > -1; i--) {
      dp[i][col - 1] = dp[i + 1][col - 1] + grid[i][col - 1];
    }
    for (int j = col - 2; j > -1; j--) {
      dp[row - 1][j] = dp[row - 1][j + 1] + grid[row - 1][j];
    }
    for (int i = row - 2; i > -1; i--) {
      for (int j = col - 2; j > -1; j--) {
        if (dp[i + 1][j] < dp[i][j + 1]) {
          dp[i][j] = dp[i + 1][j] + grid[i][j];
        } else {
          dp[i][j] = dp[i][j + 1] + grid[i][j];
        }
      }
    }
    return dp[0][0];
  }
}
