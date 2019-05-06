import java.util.Arrays;

public class Solution {

  private int g_maxValue;

  public Solution() {
    g_maxValue = 6;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.numberOfDice(1)));
    System.out.println(Arrays.toString(s.numberOfDice(2)));
    System.out.println(Arrays.toString(s.numberOfDice(3)));
    System.out.println(Arrays.toString(s.numberOfDice(-1)));
  }

  public int[] numberOfDice(int n) {
    if (n < 1) {
      return new int[] {};
    }
    int[][] dp = new int[2][g_maxValue * n + 1];
    for (int j = 1; j <= g_maxValue; j++) {
      dp[1][j] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= 6 * i; j++) {
        int k = 1;
        dp[i % 2][j] = 0;
        while (k <= 6 && j - k >= 1) {
          dp[i % 2][j] += dp[(i - 1) % 2][j - k];
          k++;
        }
      }
    }
    return Arrays.copyOfRange(dp[n % 2], n, g_maxValue * n + 1);
  }
}
