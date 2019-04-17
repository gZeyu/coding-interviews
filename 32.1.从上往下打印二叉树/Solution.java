import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        System.out.println(n0);
        System.out.println(s.PrintFromTopToBottom(n0));
        System.out.println(s.PrintFromTopToBottom(null));
        System.out.println(s.PrintFromTopToBottom(new TreeNode(0)));
        return;
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> out = new ArrayList<>();
        if (root == null) {
            return out;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            out.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            queue.poll();
        }
        return out;
    }
}
