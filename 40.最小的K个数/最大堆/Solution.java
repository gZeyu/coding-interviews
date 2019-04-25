import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] array;
    array = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
    System.out.println(s.GetLeastNumbers_Solution(array, 7));
    array = new int[] { 1 };
    System.out.println(s.GetLeastNumbers_Solution(array, 1));
    array = new int[] { 1 };
    System.out.println(s.GetLeastNumbers_Solution(array, 2));
    array = new int[] {};
    System.out.println(s.GetLeastNumbers_Solution(array, 2));
    array = null;
    System.out.println(s.GetLeastNumbers_Solution(array, 2));
  }

  public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    ArrayList<Integer> output = new ArrayList<>();
    if (input == null || input.length == 0 || k <= 0 || k > input.length) {
      return output;
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
      return o2 - o1;
    });
    for (int i = 0; i < k; i++) {
      maxHeap.offer(input[i]);
    }
    for (int i = k; i < input.length; i++) {
      @SuppressWarnings("null")
      int max = maxHeap.peek();
      if (input[i] < max) {
        maxHeap.poll();
        maxHeap.offer(input[i]);
      }
    }
    for (int i = 0; i < k; i++) {
      output.add(maxHeap.peek());
      maxHeap.poll();
    }

    for (int i = 0; i < k >> 1; i++) {
      Integer tmp = output.get(i);
      output.set(i, output.get(k - i - 1));
      output.set(k - i - 1, tmp);
    }

    return output;
  }
}
