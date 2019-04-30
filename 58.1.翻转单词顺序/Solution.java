public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.ReverseSentence("I am a student."));
  }

  public String ReverseSentence(String str) {
    if (str == null || str.length() == 0) {
      return "";
    }
    char[] ch = str.toCharArray();
    int left = 0;
    int right = left;
    while (right <= ch.length) {
      if (ch[left] == ' ') {
        left++;
        right = left;
      }
      if (right >= ch.length || ch[right] == ' ') {
        reverse(ch, left, right);
        left = right + 1;
        right = left;
      }
      right++;
    }
    reverse(ch, 0, ch.length);
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
