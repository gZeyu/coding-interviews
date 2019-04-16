public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode pHead;
        pHead = ListNode.createList(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        pHead.next.next.next.next.next.next = pHead.next.next.next;
        s.EntryNodeOfLoop(pHead);
        System.out.println(s.getNodeOfLoop(pHead).val);
        return;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode node1 = getNodeOfLoop(pHead);
        if (node1 == null) {
            return null;
        }
        ListNode node2 = node1.next;
        int lengthOfLoop = 1;
        while (node1 != node2) {
            lengthOfLoop++;
            node2 = node2.next;
        }
        System.out.println(lengthOfLoop);
        return pHead;
    }

    private ListNode getNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode node1 = pHead;
        ListNode node2 = pHead.next;
        while (node1 != null && node2 != null && node2.next != null && node1.val != node2.val) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        if (node1 == null || node2 == null || node2.next == null) {
            return null;
        }
        return node1;
    }
}
