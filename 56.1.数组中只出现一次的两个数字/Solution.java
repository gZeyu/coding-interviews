public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    int num1[] = new int[1];
    int num2[] = new int[1];
    s.FindNumsAppearOnce(new int[] { 2, 4, 3, 6, 3, 2, 5, 5 }, num1, num2);
    System.out.println(num1[0] + "," + num2[0]);
  }

  public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
    if (array == null || num1 == null || num2 == null) {
      return;
    }
    int xor = 0;
    for (int i = 0; i < array.length; i++) {
      xor ^= array[i];
    }
    int mask = getFirstOneBit(xor);
    num1[0] = 0;
    num2[0] = 0;
    for (int i = 0; i < array.length; i++) {
      if ((array[i] & mask) != 0) {
        num1[0] ^= array[i];
      } else {
        num2[0] ^= array[i];
      }
    }
  }

  private int getFirstOneBit(int num) {
    return num ^ (num & (num - 1));
  }
}
