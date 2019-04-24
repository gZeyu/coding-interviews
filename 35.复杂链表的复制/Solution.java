public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    RandomListNode n0 = new RandomListNode(0);
    RandomListNode n1 = new RandomListNode(1);
    RandomListNode n2 = new RandomListNode(2);
    RandomListNode n3 = new RandomListNode(3);
    RandomListNode n4 = new RandomListNode(4);
    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n0.random = n2;
    n1.random = n4;
    n3.random = n1;
    System.out.println(n0);
    System.out.println(s.Clone(n0));
    System.out.println(n0);
    return;
  }

  public RandomListNode Clone(RandomListNode pHead) {
    CloneNodes(pHead);
    ConnetRandomNodes(pHead);
    return ReconnectNodes(pHead);
  }

  private void CloneNodes(RandomListNode pHead) {
    RandomListNode node = pHead;
    while (node != null) {
      RandomListNode copy = new RandomListNode(node.label);
      copy.next = node.next;
      node.next = copy;
      node = copy.next;
    }
  }

  private void ConnetRandomNodes(RandomListNode pHead) {
    RandomListNode node = pHead;
    while (node != null) {
      node.next.random = (node.random != null) ? node.random.next : null;
      node = node.next.next;
    }
  }

  private RandomListNode ReconnectNodes(RandomListNode pHead) {
    if (pHead == null) {
      return null;
    }
    RandomListNode pNode = pHead;
    RandomListNode pCloneHead = pNode.next;
    RandomListNode pCloneNode = pNode.next;
    pNode.next = pCloneNode.next;
    pNode = pNode.next;
    while (pNode != null) {
      pCloneNode.next = pNode.next;
      pCloneNode = pCloneNode.next;
      pNode.next = pNode.next.next;
      pNode = pNode.next;
    }
    return pCloneHead;
  }
}
