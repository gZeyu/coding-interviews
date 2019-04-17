import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode pHead;
        pHead = ListNode.createList(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        System.out.println(s.deleteDuplication(pHead));
        pHead = ListNode.createList(new int[] { 2, 1, 1 });
        System.out.println(s.deleteDuplication(pHead));
        pHead = ListNode.createList(new int[] { 1, 1, 2 });
        System.out.println(s.deleteDuplication(pHead));
        pHead = ListNode.createList(new int[] { 1, 1, 1 });
        System.out.println(s.deleteDuplication(pHead));
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode preNode = null;
        ListNode node = pHead;
        boolean needDelete = false;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int value = node.val;
                while (node != null && node.val == value) {
                    node = node.next;
                }
                if (preNode == null) {
                    pHead = node;
                } else {
                    preNode.next = node;
                }
            } else {
                preNode = node;
                node = node.next;
            }
        }
        return pHead;
    }
}