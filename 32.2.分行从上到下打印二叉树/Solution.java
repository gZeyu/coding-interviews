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
        System.out.println(s.Print(n0));
        return;
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if (pRoot == null) {
            return out;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sizeOfNextLevel = 0;
        int needPrinting = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            queue.poll();
            arrayList.add(node.val);
            needPrinting--;
            if (node.left != null) {
                queue.offer(node.left);
                sizeOfNextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                sizeOfNextLevel++;
            }
            if (needPrinting <= 0) {
                needPrinting = sizeOfNextLevel;
                sizeOfNextLevel = 0;
                out.add(arrayList);
                arrayList = new ArrayList<>();
            }
        }
        return out;
    }
}
