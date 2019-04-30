public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
  }

  public int missingNumber(int[] nums) {
    if (nums == null) {
      return -1;
    }
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    return ((nums.length * (nums.length + 1)) >> 1) - sum;
  }
}
