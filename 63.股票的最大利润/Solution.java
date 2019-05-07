public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maxDiff(new int[] { 9, 11, 8, 5, 7, 12, 16, 14 }));
    System.out.println(s.maxDiff(new int[] { 3, 2, 1 }));
  }

  public int maxDiff(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }
    int min = nums[0];
    int maxDiff = nums[1] - nums[0];
    for (int i = 2; i < nums.length; i++) {
      min = min > nums[i - 1] ? nums[i - 1] : min;
      maxDiff = maxDiff < nums[i] - min ? nums[i] - min : maxDiff;
    }
    return maxDiff > 0 ? maxDiff : 0;
  }
}
