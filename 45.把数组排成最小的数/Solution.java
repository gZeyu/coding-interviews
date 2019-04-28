import java.util.PriorityQueue;

public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.PrintMinNumber(new int[] { 3, 32, 321 }));
    System.out.println(s.PrintMinNumber(new int[] { 3, 321, 32 }));
    System.out.println(s.PrintMinNumber(new int[] { 321, 32, 3 }));
    System.out.println(s.PrintMinNumber(new int[] { 1 }));
    System.out.println(s.PrintMinNumber(new int[] {}));
    System.out.println(s.PrintMinNumber(null));
  }

  public String PrintMinNumber(int[] numbers) {
    if (numbers == null) {
      return null;
    }
    String[] numberStrings = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      numberStrings[i] = String.valueOf(numbers[i]);
    }
    PriorityQueue<String> minHeap = new PriorityQueue<>((o1, o2) -> {
      StringBuilder b1 = new StringBuilder();
      StringBuilder b2 = new StringBuilder();
      b1.append(o1).append(o2);
      b2.append(o2).append(o1);
      for (int i = 0; i < b1.length(); i++) {
        if (b1.charAt(i) != b2.charAt(i)) {
          return b1.charAt(i) - b2.charAt(i);
        }
      }
      return 0;
    });
    for (String numberString : numberStrings) {
      minHeap.offer(numberString);
    }
    StringBuilder builder = new StringBuilder();
    while (!minHeap.isEmpty()) {
      builder.append(minHeap.peek());
      minHeap.poll();
    }
    return builder.toString();
  }
}
