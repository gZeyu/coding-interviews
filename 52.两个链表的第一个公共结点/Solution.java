public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode pHead1;
        ListNode pHead2;
        pHead1 = ListNode.createList(new int[] { 1, 2, 3, 6, 7 });
        pHead2 = ListNode.createList(new int[] { 4, 5 });
        System.out.println(s.FindFirstCommonNode(pHead1, pHead2));
        pHead2.next.next = pHead1.next.next.next;
        System.out.println(s.FindFirstCommonNode(pHead1, pHead2));
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        int length1 = 0;
        int length2 = 0;
        while (node1 != null) {
            node1 = node1.next;
            length1++;
        }
        while (node2 != null) {
            node2 = node2.next;
            length2++;
        }
        ListNode node3 = length1 >= length2 ? pHead1 : pHead2;
        ListNode node4 = length1 < length2 ? pHead1 : pHead2;
        int diff = length1 > length2 ? length1 - length2 : length2 - length1;
        for (int i = 0; i < diff; i++) {
            node3 = node3.next;
        }
        while (node3 != null && node4 != null && node3.val != node4.val) {
            node3 = node3.next;
            node4 = node4.next;
        }
        return node3;
    }
}
