import java.util.ArrayList;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] array;
    array = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
    System.out.println(s.GetLeastNumbers_Solution(array, 7));
    array = new int[] {1};
    System.out.println(s.GetLeastNumbers_Solution(array, 1));
    array = new int[] {1};
    System.out.println(s.GetLeastNumbers_Solution(array, 2));
    array = new int[] {};
    System.out.println(s.GetLeastNumbers_Solution(array, 2));
    array = null;
    System.out.println(s.GetLeastNumbers_Solution(array, 2));
  }

  public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    ArrayList<Integer> output = new ArrayList<>();
    if (input == null || input.length == 0 || k <= 0 || k > input.length) {
      return output;
    }
    int left = 0;
    int right = input.length - 1;
    int pivotIndex = partition(input, left, right);
    while (pivotIndex != k - 1) {
      if (pivotIndex > k - 1) {
        right = pivotIndex - 1;
      } else {
        left = pivotIndex + 1;
      }
      pivotIndex = partition(input, left, right);
    }
    for (int i = 0; i < k; i++) {
      output.add(input[i]);
    }
    return output;
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
