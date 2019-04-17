public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" + (left == null ? "" : left.toString()) + val + (right == null ? "" : right.toString()) + "}";
    }
}
