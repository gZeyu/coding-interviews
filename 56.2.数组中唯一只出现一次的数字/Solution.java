public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findNumberAppearingOnce(new int[] { 1, 1, 1, 2, 2, 2, 3, 4, 4, 4 }));
  }

  public int findNumberAppearingOnce(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] bits = new int[32];
    for (int i = 0; i < nums.length; i++) {
      int tmp = nums[i];
      for (int j = 0; j < 32; j++) {
        bits[j] += tmp & 1;
        tmp >>= 1;
      }
    }
    int result = 0;
    for (int i = 31; i > -1; i--) {
      result <<= 1;
      result += bits[i] % 3;
    }
    return result;
  }
}
