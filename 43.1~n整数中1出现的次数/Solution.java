public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.NumberOf1Between1AndN_Solution(21345));
    System.out.println(s.NumberOf1Between1AndN_Solution(12));
    System.out.println(s.NumberOf1Between1AndN_Solution(-1));
  }

  public int NumberOf1Between1AndN_Solution(int n) {
    if (n <= 0) {
      return 0;
    } else if (n < 10) {
      return 1;
    }
    char[] str = String.valueOf(n).toCharArray();
    int firstDigit = str[0] - '0';
    int otherDigits = n % ((int) Math.pow(10, str.length - 1));
    int numberOfFirstDigit = 0;
    int numberOfOtherDigits = 0;
    if (firstDigit > 1) {
      numberOfFirstDigit = (int) Math.pow(10, str.length - 1);
    } else {
      numberOfFirstDigit = otherDigits + 1;
    }
    numberOfOtherDigits = firstDigit * (str.length - 1) * (int) Math.pow(10, str.length - 2);
    return numberOfFirstDigit + numberOfOtherDigits + NumberOf1Between1AndN_Solution(otherDigits);
  }
}
