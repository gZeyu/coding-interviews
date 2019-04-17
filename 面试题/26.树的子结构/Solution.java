public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        TreeNode m0 = new TreeNode(1);
        TreeNode m1 = new TreeNode(3);
        TreeNode m2 = new TreeNode(4);
        m0.left = m1;
        m0.right = m2;
        System.out.println(n0);
        System.out.println(m0);
        System.out.println(s.HasSubtree(n0, m0));
        System.out.println(s.HasSubtree(n0, null));
        System.out.println(s.HasSubtree(null, m0));
        System.out.println(s.HasSubtree(null, null));
        // System.out.println(s.isEqual(1, 2));
        return;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isEqual(root1, root2) || isEqual(root1.left, root2) || isEqual(root1.right, root2);
    }

    public boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (!isEqual(root1.val, root2.val)) {
            return false;
        }
        return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
    }

    public boolean isEqual(double num1, double num2) {
        return (num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001);
    }
}
