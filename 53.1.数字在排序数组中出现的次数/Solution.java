public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.GetNumberOfK(new int[] { 1, 2, 3, 3, 3, 3, 4, 5 }, 3));
    System.out.println(s.GetNumberOfK(new int[] { 1, 2, 3, 3, 3, 3, 4, 5 }, 1));
    System.out.println(s.GetNumberOfK(new int[] { 1, 2, 3, 3, 3, 3, 4, 5 }, 2));
    System.out.println(s.GetNumberOfK(new int[] { 1, 2, 3, 3, 3, 3, 4, 5 }, 4));
    System.out.println(s.GetNumberOfK(new int[] { 1, 2, 3, 3, 3, 3, 4, 5 }, 5));
    System.out.println(s.GetNumberOfK(null, 1));
    System.out.println(s.GetNumberOfK(new int[] {}, 1));
  }

  public int GetNumberOfK(int[] array, int k) {
    if (array == null || array.length == 0) {
      return 0;
    }
    int firstIndex = getFirstIndexOfK(array, k);
    int lastIndex = getLastIndexOfK(array, k);
    if (firstIndex == -1) {
      return 0;
    }
    return lastIndex - firstIndex + 1;
  }

  private int getFirstIndexOfK(int[] array, int k) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int middle = (left + right) >> 1;
      if (array[middle] == k && (middle == 0 || array[middle - 1] != k)) {
        return middle;
      } else if (array[middle] < k) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return -1;
  };

  private int getLastIndexOfK(int[] array, int k) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int middle = (left + right) >> 1;
      if (array[middle] == k && (middle == array.length - 1 || array[middle + 1] != k)) {
        return middle;
      } else if (array[middle] > k) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return -1;
  };
}
