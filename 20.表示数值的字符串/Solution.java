public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumeric("+100".toCharArray()));
        System.out.println(s.isNumeric("5e2".toCharArray()));
        System.out.println(s.isNumeric("-123".toCharArray()));
        System.out.println(s.isNumeric("3.1416".toCharArray()));
        System.out.println(s.isNumeric("-1E-16".toCharArray()));
        System.out.println(s.isNumeric("12e".toCharArray()));
    }

    private int idx;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        idx = 0;
        boolean result = false;
        result = scanInteger(str);
        if (idx < str.length && str[idx] == '.') {
            idx++;
            result = scanUnsignedInteger(str) || result;
        }
        if (idx < str.length && (str[idx] == 'e' || str[idx] == 'E')) {
            idx++;
            result = scanInteger(str) && result;
        }
        return result && idx == str.length;

    }

    private boolean scanUnsignedInteger(char[] str) {
        int preIdx = idx;
        while (idx < str.length && str[idx] >= '0' && str[idx] <= '9') {
            idx++;
        }
        return idx > preIdx;
    }

    private boolean scanInteger(char[] str) {
        if (idx < str.length && (str[idx] == '+' || str[idx] == '-')) {
            idx++;
        }
        return scanUnsignedInteger(str);
    }
}