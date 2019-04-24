import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode n0 = new TreeNode(4);
    TreeNode n1 = new TreeNode(2);
    TreeNode n2 = new TreeNode(6);
    TreeNode n3 = new TreeNode(1);
    TreeNode n4 = new TreeNode(3);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(7);
    n0.left = n1;
    n0.right = n2;
    n1.left = n3;
    n1.right = n4;
    n2.left = n5;
    n2.right = n6;
    System.out.println(n0);
    TreeNode node = s.Convert(n0);
    TreeNode prev = node;
    while (node != null) {
      prev = node;
      System.out.print(node.val + "->");
      node = node.right;
      if (node == null) {
        System.out.println("null");
      }
    }
    node = prev;
    while (node != null) {
      System.out.print(node.val + "->");
      node = node.left;
      if (node == null) {
        System.out.println("null");
      }
    }
  }

  public TreeNode Convert(TreeNode pRootOfTree) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = pRootOfTree;
    TreeNode prev = null;
    TreeNode cur;
    while (!stack.empty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.right;
      }
      if (!stack.empty()) {
        node = stack.peek();
        cur = node;
        stack.pop();
        node = node.left;
        cur.right = prev;
        if (prev != null) {
          prev.left = cur;
        }
        prev = cur;
      }
    }
    return prev;
  }
}
