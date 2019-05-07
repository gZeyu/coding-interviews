import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.multiply(new int[] { 1, 2, 3, 4, 5 })));
  }

  public int[] multiply(int[] A) {
    if (A == null || A.length < 1) {
      return new int[] {};
    }
    int[] B = new int[A.length];
    int[] C = new int[A.length];
    B[0] = 1;
    for (int i = 1; i < A.length; i++) {
      B[i] = B[i - 1] * A[i - 1];
    }
    C[A.length - 1] = 1;
    for (int i = A.length - 2; i > -1; i--) {
      C[i] = C[i + 1] * A[i + 1];
      B[i] *= C[i];
    }
    return B;
  }
}
