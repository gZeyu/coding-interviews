public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode pHead;
        pHead = ListNode.createList(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        System.out.println(s.FindKthToTail(pHead, 8));
        return;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        int i = 0;
        ListNode node = head;
        while (node != null && i < k) {
            node = node.next;
            i++;
        }
        if (i < k) {
            return null;
        }
        ListNode kthNode = head;
        while (node != null) {
            kthNode = kthNode.next;
            node = node.next;
        }
        return kthNode;
    }
}
