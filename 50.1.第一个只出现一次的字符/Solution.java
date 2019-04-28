import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.FirstNotRepeatingChar("abaccdeff"));
    System.out.println(s.FirstNotRepeatingChar(""));
    System.out.println(s.FirstNotRepeatingChar(null));
  }

  public int FirstNotRepeatingChar(String str) {
    if (str == null || str.length() == 1) {
      return -1;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (map.containsKey(str.charAt(i))) {
        map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
      } else {
        map.put(str.charAt(i), 1);
      }
    }
    for (int i = 0; i < str.length(); i++) {
      if (map.get(str.charAt(i)) == 1) {
        return i;
      }
    }
    return 0;
  }
}
