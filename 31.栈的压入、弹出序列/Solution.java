import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
    System.out.println(s.IsPopOrder(new int[] { 1 }, new int[] { 1 }));
    System.out.println(s.IsPopOrder(new int[] { 1, 2 }, new int[] { 1, 2 }));
    System.out.println(s.IsPopOrder(new int[] { 2, 1 }, new int[] { 1, 2 }));
    System.out.println(s.IsPopOrder(new int[] { 1, 1 }, new int[] { 1, 2 }));
    System.out.println(s.IsPopOrder(new int[] { 1, 1 }, new int[] { 1 }));
    System.out.println(s.IsPopOrder(new int[] {}, new int[] {}));
    return;
  }

  private Stack<Integer> stack = new Stack<>();

  public boolean IsPopOrder(int[] pushA, int[] popA) {
    if (pushA == null || popA == null || pushA.length != popA.length) {
      return false;
    }

    int pushIdx = 0;
    int popIdx = 0;
    while (!(pushIdx >= pushA.length && (popIdx >= popA.length || stack.peek() != popA[popIdx]))) {
      if (stack.empty() || stack.peek() != popA[popIdx]) {
        stack.push(pushA[pushIdx]);
        pushIdx++;
      } else {
        stack.pop();
        popIdx++;
      }
    }
    return stack.empty();
  }
}
