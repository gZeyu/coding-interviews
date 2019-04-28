public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.InversePairs(new int[] { 1, 2, 3, 4, 5, 6, 7, 0 }));
    System.out.println(s.InversePairs(new int[] { 7, 5, 6, 4 }));
    System.out.println(s.InversePairs(new int[] { 1, 1, 1, 1 }));
    System.out.println(s.InversePairs(new int[] { 0 }));
    System.out.println(s.InversePairs(new int[] {}));
    System.out.println(s.InversePairs(null));
  }

  public int InversePairs(int[] array) {
    if (array == null || array.length < 2) {
      return 0;
    }
    count = 0;
    int[] copy = new int[array.length];
    MergeSortAndCount(array, copy, 0, array.length - 1);
    return count % 1000000007;
  }

  private int count;

  private void MergeSortAndCount(int[] array, int[] copy, int left, int right) {
    if (left < right) {
      int middle = (left + right) >> 1;
      MergeSortAndCount(array, copy, left, middle);
      MergeSortAndCount(array, copy, middle + 1, right);
      MergeAndCount(array, copy, left, middle, right);
    }
  }

  private void MergeAndCount(int[] array, int[] copy, int left, int middle, int right) {
    int end1 = middle;
    int end2 = right;
    int end3 = right;
    while (end1 >= left && end2 > middle) {
      if (array[end1] > array[end2]) {
        copy[end3] = array[end1];
        end1--;
        count += end2 - middle;
        count %= 1000000007;
      } else {
        copy[end3] = array[end2];
        end2--;
      }
      end3--;
    }
    while (end1 >= left) {
      copy[end3] = array[end1];
      end1--;
      end3--;
    }
    while (end2 > middle) {
      copy[end3] = array[end2];
      end2--;
      end3--;
    }
    for (int i = left; i <= right; i++) {
      array[i] = copy[i];
    }
  }
}
