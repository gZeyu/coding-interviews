import java.util.ArrayList;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.FindNumbersWithSum(new int[] { 1, 2, 4, 7, 11, 15 }, 15));
    System.out.println(s.FindNumbersWithSum(new int[] {}, 190));
  }

  public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
    ArrayList<Integer> result = new ArrayList<>();
    if (array == null || array.length < 2) {
      return result;
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      if (array[left] + array[right] == sum) {
        result.add(array[left]);
        result.add(array[right]);
        break;
      } else if (array[left] + array[right] > sum) {
        right--;
      } else {
        left++;
      }
    }
    return result;
  }
}
