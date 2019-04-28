import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(s.lengthOfLongestSubstring("abba"));
  }

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    for (int j = 0, i = 0; j < s.length(); j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      max = Math.max(max, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return max;
  }
}
