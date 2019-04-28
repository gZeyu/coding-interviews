import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    Solution s;
    String str;
    str = "google";
    s = new Solution();
    for (char c : str.toCharArray()) {
      s.Insert(c);
    }
    System.out.println(s.FirstAppearingOnce());
    str = "go";
    s = new Solution();
    for (char c : str.toCharArray()) {
      s.Insert(c);
    }
    System.out.println(s.FirstAppearingOnce());
  }

  private Map<Character, Integer> map;
  private int index;

  public Solution() {
    map = new HashMap<>();
    index = 0;
  }

  // Insert one char from stringstream
  public void Insert(char ch) {
    if (map.containsKey(ch)) {
      map.put(ch, -1);
    } else {
      map.put(ch, index);
      index++;
    }
  }

  // return the first appearence once char in current stringstream
  public char FirstAppearingOnce() {
    int first = index;
    char result = '#';
    for (char ch : map.keySet()) {
      if (map.get(ch) != -1 && map.get(ch) < first) {
        first = map.get(ch);
        result = ch;
      }
    }
    return result;
  }
}
