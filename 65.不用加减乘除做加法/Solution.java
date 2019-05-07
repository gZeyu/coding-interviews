public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.Add(1, 3));
    System.out.println(s.Add(1, 2));
    System.out.println(s.Add(2, 3));
    System.out.println(s.Add(5, 6));
  }

  public int Add(int num1, int num2) {
    int c = 0;
    int s = 0;
    int mask = 1;
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      s = (num1 & mask) ^ c;
      ans |= (num2 & mask) ^ s;
      c = (num1 & mask) & c;
      c |= (num2 & mask) & s;
      c <<= 1;
      mask <<= 1;
    }
    return ans;
  }
}
