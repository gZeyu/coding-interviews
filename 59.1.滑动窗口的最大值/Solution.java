import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maxInWindows(new int[] { 2, 3, 4, 2, 6, 2, 5, 1 }, 3));
    System.out.println(s.maxInWindows(new int[] { 2, 3, 4, 2, 6, 2, 5, 1 }, 20));
    System.out.println(s.maxInWindows(null, 10));
  }

  public ArrayList<Integer> maxInWindows(int[] num, int size) {
    ArrayList<Integer> maxList = new ArrayList<>();
    // System.out.println(num.length + "," + size);
    if (num == null || size < 1 || num.length < size) {
      return maxList;
    }
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }
    for (int i = size; i < num.length; i++) {
      maxList.add(num[deque.peekFirst()]);
      while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
        deque.pollLast();
      }
      if (!deque.isEmpty() && deque.peekFirst() <= i - size) {
        deque.pollFirst();
      }
      deque.offerLast(i);
    }
    maxList.add(num[deque.peekFirst()]);
    return maxList;
  }
}
