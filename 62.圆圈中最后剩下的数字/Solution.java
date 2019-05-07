public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.LastRemaining_Solution(5, 3));
  }

  public int LastRemaining_Solution(int n, int m) {
    if (m == 0 || n == 0) {
      return -1;
    }
    int dp = 0;
    for (int i = 2; i <= n; i++) {
      dp = (dp + m) % i;
    }
    return dp;
  }
}
