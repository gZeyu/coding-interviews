public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] array;
    array = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
    System.out.println(s.MoreThanHalfNum_Solution(array));
    array = new int[] { 1, 2, 2 };
    System.out.println(s.MoreThanHalfNum_Solution(array));
    array = new int[] { 1 };
    System.out.println(s.MoreThanHalfNum_Solution(array));
    array = new int[] {};
    System.out.println(s.MoreThanHalfNum_Solution(array));
    array = null;
    System.out.println(s.MoreThanHalfNum_Solution(array));
  }

  public int MoreThanHalfNum_Solution(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    int result = array[0];
    int times = 1;
    for (int i = 1; i < array.length; i++) {
      if (times == 0) {
        result = array[i];
        times = 1;
      } else if (result == array[i]) {
        times++;
      } else {
        times--;
      }
    }
    if (checkMoreThanHalf(array, result)) {
      return result;
    } else {
      return 0;
    }
  }

  private boolean checkMoreThanHalf(int[] array, int result) {
    int times = 0;
    for (int i = 0; i < array.length; i++) {
      if (result == array[i]) {
        times++;
      }
    }
    if (times << 1 > array.length) {
      return true;
    } else {
      return false;
    }
  }
}
