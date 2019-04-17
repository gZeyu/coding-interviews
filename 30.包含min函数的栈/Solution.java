import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    return;
  }

  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();

  public void push(int node) {
    stack1.push(node);
    if (stack2.empty()) {
      stack2.push(node);
    } else {
      stack2.push(node < stack2.peek() ? node : stack2.peek());
    }
  }

  public void pop() {
    stack1.pop();
    stack2.pop();
  }

  public int top() {
    return stack1.peek();
  }

  public int min() {
    return stack2.peek();
  }
}
