public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.LeftRotateString("abcdefg", 2));
    System.out.println(s.LeftRotateString("abcdefg", 0));
    System.out.println(s.LeftRotateString("", 6));
  }

  public String LeftRotateString(String str, int n) {
    if (str == null || str.length() == 0 || n % str.length() == 0) {
      return str;
    }
    char[] ch = str.toCharArray();
    int shift = n % str.length();
    reverse(ch, 0, str.length());
    reverse(ch, 0, str.length() - shift);
    reverse(ch, str.length() - shift, str.length());
    return String.valueOf(ch);
  }

  private void reverse(char[] ch, int left, int right) {
    int i = left;
    int j = right - 1;
    while (i < j) {
      char tmp = ch[i];
      ch[i] = ch[j];
      ch[j] = tmp;
      i++;
      j--;
    }
  }
}
