public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String buff;
        buff = "1,2,4,#,#,#,3,5,#,#,6,#,#";
        System.out.println(s.Deserialize(buff));
        System.out.println(s.Serialize(s.Deserialize(buff)));
        buff = "#";
        System.out.println(s.Deserialize(buff));
        System.out.println(s.Serialize(s.Deserialize(buff)));
        buff = null;
        System.out.println(s.Deserialize(buff));
        System.out.println(s.Serialize(s.Deserialize(buff)));
    }

    private int index;

    public String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        SerializeCore(root, builder);
        return builder.toString();
    }

    private void SerializeCore(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append('#').append(',');
            return;
        }
        builder.append(root.val).append(',');
        SerializeCore(root.left, builder);
        SerializeCore(root.right, builder);
    }

    public TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] buff = str.split(",");
        index = 0;
        return DeserializeCore(buff);
    }

    private TreeNode DeserializeCore(String[] buff) {
        if (index > buff.length) {
            return null;
        }
        TreeNode node = null;
        if (!buff[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(buff[index]));
            index++;
            node.left = DeserializeCore(buff);
            index++;
            node.right = DeserializeCore(buff);
        }
        return node;
    }
}
