public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] array;
    array = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
    System.out.println(s.MoreThanHalfNum_Solution(array));
    array = new int[] {1, 2, 2};
    System.out.println(s.MoreThanHalfNum_Solution(array));
    array = new int[] {1};
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
    int middle = array.length >> 1;
    int left = 0;
    int right = array.length - 1;
    int pivotIndex = partition(array, left, right);
    while (pivotIndex != middle) {
      if (pivotIndex > middle) {
        right = pivotIndex - 1;
      } else {
        left = pivotIndex + 1;
      }
      pivotIndex = partition(array, left, right);
    }
    if (checkMoreThanHalf(array, array[pivotIndex])) {
      return array[pivotIndex];
    } else {
      return 0;
    }
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  private int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int i = left - 1;
    for (int j = left; j < right; j++) {
      if (array[j] <= pivot) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, right);
    return i + 1;
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
