public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findNthDigit(188));
    System.out.println(s.findNthDigit(189));
    System.out.println(s.findNthDigit(10));
    System.out.println(s.findNthDigit(11));
    System.out.println(s.findNthDigit(19));
    System.out.println(s.findNthDigit(1000000000));
  }

  public int findNthDigit(int n) {
    long digits = n;
    long lengthOfNDigitNumber = 1;
    long totalLengthOfNDigitNumber = 9;
    while (digits > totalLengthOfNDigitNumber) {
      digits -= totalLengthOfNDigitNumber;
      lengthOfNDigitNumber++;
      totalLengthOfNDigitNumber = lengthOfNDigitNumber * 9 * (int) Math.pow(10, lengthOfNDigitNumber - 1);
    }
    long NDigitNumber = (long) Math.pow(10, lengthOfNDigitNumber - 1) + (digits - 1) / lengthOfNDigitNumber;
    digits = (digits - 1) % lengthOfNDigitNumber + 1;
    return (int) (NDigitNumber / (long) Math.pow(10, lengthOfNDigitNumber - digits) % 10);
  }
}
