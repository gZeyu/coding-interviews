import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(8);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println(n0);
        System.out.println(s.KthNode(n0, 3));
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        int count = 0;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.peek();
                stack.pop();
                System.out.println(node.val);
                count++;
                if (count >= k) {
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }
}
