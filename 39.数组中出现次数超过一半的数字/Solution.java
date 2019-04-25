import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Permutation("123"));
        System.out.println(s.Permutation("12"));
        System.out.println(s.Permutation("1223"));
        System.out.println(s.Permutation("a"));
        System.out.println(s.Permutation(""));
        System.out.println(s.Permutation(null));
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> out = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return out;
        }
        char[] buff = str.toCharArray();
        do {
            out.add(new String(buff));
        } while (NextPermutation(buff));
        return out;
    }

    public void swap(char[] buff, int i, int j) {
        char tmp = buff[i];
        buff[i] = buff[j];
        buff[j] = tmp;
    }

    public void reverse(char[] buff, int start, int end) {
        int i = start;
        int j = end - 1;
        while (i < j) {
            swap(buff, i, j);
            i++;
            j--;
        }
    }

    public boolean NextPermutation(char[] buff) {
        if (buff.length < 2) {
            return false;
        }
        int j = buff.length - 2;
        while (j >= 0 && buff[j] >= buff[j + 1]) {
            j--;
        }
        if (j < 0) {
            reverse(buff, 0, buff.length);
            return false;
        }
        int k = buff.length - 1;
        while (j < k && buff[j] >= buff[k]) {
            k--;
        }
        swap(buff, j, k);
        reverse(buff, j + 1, buff.length);
        return true;
    }
}
