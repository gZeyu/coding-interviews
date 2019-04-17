public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
        System.out.println(s.match("aaa".toCharArray(), "a.a".toCharArray()));
        System.out.println(s.match("".toCharArray(), ".*".toCharArray()));
        System.out.println(s.match("".toCharArray(), ".".toCharArray()));
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    public boolean matchCore(char[] str, char[] pattern, int pStr, int pPattern) {
        if (pStr == str.length && pPattern == pattern.length) {
            return true;
        }
        if (pStr < str.length && pPattern >= pattern.length) {
            return false;
        }
        if (pPattern + 1 < pattern.length && pattern[pPattern + 1] == '*') {
            if (pStr < str.length && (str[pStr] == pattern[pPattern] || pattern[pPattern] == '.')) {
                return matchCore(str, pattern, pStr + 1, pPattern) || matchCore(str, pattern, pStr, pPattern + 2)
                        || matchCore(str, pattern, pStr + 1, pPattern + 2);
            } else {
                return matchCore(str, pattern, pStr, pPattern + 2);
            }
        }
        if (pStr < str.length && (str[pStr] == pattern[pPattern] || pattern[pPattern] == '.')) {
            return matchCore(str, pattern, pStr + 1, pPattern + 1);
        }
        return false;
    }
}