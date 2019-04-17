public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "->" + (next == null ? "null" : next.toString());
    }

    public static ListNode createList(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        ListNode pHead = new ListNode(input[0]);
        ListNode node = pHead;
        for (int i = 1; i < input.length; i++) {
            node.next = new ListNode(input[i]);
            node = node.next;
        }
        return pHead;
    }

}
