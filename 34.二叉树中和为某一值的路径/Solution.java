import java.util.ArrayList;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode n0 = new TreeNode(0);
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(4);
    TreeNode n6 = new TreeNode(3);
    n0.left = n1;
    n0.right = n2;
    n1.left = n3;
    n1.right = n4;
    n2.left = n5;
    n2.right = n6;
    System.out.println(s.FindPath(n0, 5));
    return;
  }

  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    ArrayList<ArrayList<Integer>> out = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    FindPathCore(root, target, out, list);
    return out;
  }

  private void FindPathCore(TreeNode root, int target, ArrayList<ArrayList<Integer>> out, ArrayList<Integer> list) {
    if (root == null || root.val > target) {
      return;
    }
    list.add(root.val);
    if (root.left == null && root.right == null && root.val == target) {
      ArrayList<Integer> copy = new ArrayList<>(list);
      out.add(copy);
    }
    FindPathCore(root.left, target - root.val, out, list);
    FindPathCore(root.right, target - root.val, out, list);
    list.remove(list.size() - 1);
  }
}
