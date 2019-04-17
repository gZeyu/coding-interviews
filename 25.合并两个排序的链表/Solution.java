public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list1, list2;
        list1 = ListNode.createList(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        list2 = ListNode.createList(new int[] { 2, 3, 4, 4, 5, 5, 6, 7 });
        System.out.println(s.Merge(list1, list2));
        list1 = ListNode.createList(null);
        list2 = ListNode.createList(new int[] { 2, 3, 4, 4, 5, 5, 6, 7 });
        System.out.println(s.Merge(list1, list2));
        list1 = ListNode.createList(null);
        list2 = ListNode.createList(new int[] { 1 });
        System.out.println(s.Merge(list1, list2));
        list1 = ListNode.createList(null);
        list2 = ListNode.createList(null);
        System.out.println(s.Merge(list1, list2));
        return;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        ListNode node1 = list1;
        ListNode node2 = list2;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        node.next = node1 != null ? node1 : node2;
        return result.next;
    }
}
