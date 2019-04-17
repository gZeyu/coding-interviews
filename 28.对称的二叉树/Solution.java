public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n0 = new TreeNode(8);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(5);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println(n0);
        System.out.println(s.isSymmetrical(n0));
        n0 = new TreeNode(0);
        n1 = new TreeNode(1);
        n2 = new TreeNode(1);
        n3 = new TreeNode(2);
        n4 = new TreeNode(2);
        n5 = new TreeNode(3);
        n6 = new TreeNode(3);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println(n0);
        System.out.println(s.isSymmetrical(n0));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetricalCore(pRoot, pRoot);
    }

    boolean isSymmetricalCore(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 != null && pRoot2 != null && pRoot1.val == pRoot2.val) {
            return isSymmetricalCore(pRoot1.left, pRoot2.right) && isSymmetricalCore(pRoot1.right, pRoot2.left);
        }
        return false;
    }
}
