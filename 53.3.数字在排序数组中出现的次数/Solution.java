public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.getNumberSameAsIndex(new int[] { -3, -1, 1, 3, 5 }));
    System.out.println(s.getNumberSameAsIndex(new int[] { 1, 2, 3 }));
    System.out.println(s.getNumberSameAsIndex(new int[] { 0 }));
  }

  public int getNumberSameAsIndex(int[] nums) {
    if (nums == null) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = (left + right) >> 1;
      if (nums[middle] == middle) {
        return middle;
      } else if (nums[middle] < middle) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return -1;
  }
}
