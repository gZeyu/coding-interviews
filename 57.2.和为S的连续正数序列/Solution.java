import java.util.ArrayList;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.FindContinuousSequence(0));
    System.out.println(s.FindContinuousSequence(1));
    System.out.println(s.FindContinuousSequence(2));
    System.out.println(s.FindContinuousSequence(3));
    System.out.println(s.FindContinuousSequence(4));
    System.out.println(s.FindContinuousSequence(15));
  }

  public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if (sum < 0) {
      return result;
    }
    int left = 1;
    int right = 2;
    int bound = (sum + 1) >> 1;
    int currentSum;
    while (left < right && left < bound) {
      currentSum = getSum(left, right);
      if (currentSum == sum) {
        result.add(getSequence(left, right));
        left++;
      } else if (currentSum < sum) {
        right++;
      } else {
        left++;
      }
    }

    return result;
  }

  private ArrayList<Integer> getSequence(int left, int right) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      result.add(i);
    }
    return result;
  }

  private int getSum(int left, int right) {
    return (left + right) * (right - left + 1) >> 1;
  }
}
