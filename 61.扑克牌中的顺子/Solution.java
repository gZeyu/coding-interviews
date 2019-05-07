import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isContinuous(new int[] { 1, 3, 0, 0, 5 }));
    System.out.println(s.isContinuous(new int[] { 0, 1, 3, 4, 5 }));
  }

  public boolean isContinuous(int[] numbers) {
    if (numbers == null || numbers.length != 5) {
      return false;
    }
    Arrays.sort(numbers);
    int numberOfZero = 0;
    int numberOfMissingValue = 0;
    int start = 0;
    while (start < 5 && numbers[start] == 0) {
      start++;
      numberOfZero++;
    }
    if (numberOfZero > 4) {
      return false;
    }
    if (numberOfZero == 4) {
      return true;
    }
    for (int i = start + 1; i < 5; i++) {
      if (numbers[i] == numbers[i - 1]) {
        return false;
      } else {
        numberOfMissingValue += numbers[i] - numbers[i - 1] - 1;
      }
    }
    return numberOfMissingValue == numberOfZero;
  }
}
