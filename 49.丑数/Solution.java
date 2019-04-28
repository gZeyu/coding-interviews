import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.GetUglyNumber_Solution(10));
    System.out.println(s.GetUglyNumber_Solution(11));
  }

  public int GetUglyNumber_Solution(int index) {
    if (index < 1) {
      return 0;
    }
    int[] uglyNumbers = new int[index + 1];
    int idx2 = 1;
    int idx3 = 1;
    int idx5 = 1;
    uglyNumbers[1] = 1;
    for (int i = 2; i <= index; i++) {
      while (uglyNumbers[idx2] * 2 <= uglyNumbers[i - 1]) {
        idx2++;
      }
      while (uglyNumbers[idx3] * 3 <= uglyNumbers[i - 1]) {
        idx3++;
      }
      while (uglyNumbers[idx5] * 5 <= uglyNumbers[i - 1]) {
        idx5++;
      }
      uglyNumbers[i] = Math.min(Math.min(uglyNumbers[idx2] * 2, uglyNumbers[idx3] * 3), uglyNumbers[idx5] * 5);
    }
    return uglyNumbers[index];
  }
}
