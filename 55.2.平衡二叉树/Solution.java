public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;
        System.out.println(n0);
        System.out.println(s.IsBalanced_Solution(n0));
    }

    class TreeDepth {
        int val;

        public TreeDepth(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return IsBalanced_SolutionCore(root, new TreeDepth(0));
    }

    public boolean IsBalanced_SolutionCore(TreeNode root, TreeDepth treeDepth) {
        if (root == null) {
            treeDepth.val = 0;
            return true;
        }
        TreeDepth left = new TreeDepth(0);
        TreeDepth right = new TreeDepth(0);
        if (IsBalanced_SolutionCore(root.left, left) && IsBalanced_SolutionCore(root.right, right)) {
            if (left.val == right.val || left.val == right.val + 1 || left.val + 1 == right.val) {
                treeDepth.val = left.val > right.val ? (left.val + 1) : (right.val + 1);
                return true;
            }
        }
        return false;
    }
}
