public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode pHead;
        pHead = ListNode.createList(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        System.out.println(s.ReverseList(pHead));
        pHead = ListNode.createList(new int[] { 1 });
        System.out.println(s.ReverseList(pHead));
        pHead = ListNode.createList(null);
        System.out.println(s.ReverseList(pHead));
        return;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
