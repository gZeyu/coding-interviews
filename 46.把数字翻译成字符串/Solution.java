public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.numDecodings("12258"));
    System.out.println(s.numDecodings("32"));
    System.out.println(s.numDecodings("226"));
    System.out.println(s.numDecodings("12"));
    System.out.println(s.numDecodings("1"));
    System.out.println(s.numDecodings(""));
    System.out.println(s.numDecodings(null));
    System.out.println(s.numDecodings("100"));
    System.out.println(s.numDecodings("110"));
    System.out.println(s.numDecodings("0"));
    System.out.println(s.numDecodings("17"));
  }

  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] dp = new int[s.length()];
    dp[0] = s.charAt(0) >= '1' && s.charAt(0) <= '9' ? 1 : 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
        dp[i] += dp[i - 1];
      }
      if ((s.charAt(i - 1) == '1' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
          || (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) {
        dp[i] += i > 1 ? dp[i - 2] : 1;
      }
    }
    return dp[s.length() - 1];
  }
}
