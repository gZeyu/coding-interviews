public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.Sum_Solution(5));
  }

  public int Sum_Solution(int n) {
    return helpers[1].getSum(n);
  }

  Helper[] helpers;

  public Solution() {
    helpers = new Helper[2];
    helpers[0] = new EqualToZero();
    helpers[1] = new GreaterThanZero();
  }

  interface Helper {
    int getSum(int n);
  }

  class GreaterThanZero implements Helper {
    public int getSum(int n) {
      return Solution.this.helpers[compareToZero(n - 1)].getSum(n - 1) + n;
    }

    private int compareToZero(int n) {
      return (((-n) | n) >>> 31) - ((n >>> 31) << 1);
    }
  }

  class EqualToZero implements Helper {
    public int getSum(int n) {
      return 0;
    }
  }
}
