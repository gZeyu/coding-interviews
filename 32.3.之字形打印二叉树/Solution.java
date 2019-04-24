import java.util.ArrayList;
import java.util.Stack;

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

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if (pRoot == null) {
            return out;
        }
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack0.push(pRoot);
        int needPrinting = 1;
        int sizeOfNextLevel = 0;
        int level = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack0.empty() || !stack1.empty()) {
            TreeNode node;
            needPrinting--;
            if (level % 2 == 0) {
                node = stack0.peek();
                arrayList.add(node.val);
                stack0.pop();
                if (node.left != null) {
                    stack1.push(node.left);
                    sizeOfNextLevel++;
                }
                if (node.right != null) {
                    stack1.push(node.right);
                    sizeOfNextLevel++;
                }
            } else {
                node = stack1.peek();
                arrayList.add(node.val);
                stack1.pop();
                if (node.right != null) {
                    stack0.push(node.right);
                    sizeOfNextLevel++;
                }
                if (node.left != null) {
                    stack0.push(node.left);
                    sizeOfNextLevel++;
                }
            }
            if (needPrinting <= 0) {
                needPrinting = sizeOfNextLevel;
                sizeOfNextLevel = 0;
                out.add(arrayList);
                arrayList = new ArrayList<>();
                level++;
            }
        }
        return out;
    }
}
