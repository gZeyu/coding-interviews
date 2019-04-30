import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
  }

  public int missingNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    int middle;
    Arrays.sort(nums);
    while (left <= right) {
      middle = (left + right) >> 1;
      if (nums[middle] != middle && (middle == 0 || nums[middle - 1] == middle - 1)) {
        return middle;
      } else if (nums[middle] == middle) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return -1;
  }
}
