public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.Sum_Solution(5));
  }

  public int Sum_Solution(int n) {
    int sum = n;
    boolean calculator = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
    return sum;
  }

  private int compareToZero(int n) {
    return (((-n) | n) >>> 31) - ((n >>> 31) << 1);
  }
}
