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
    QueueWithMax queueWithMax = new QueueWithMax();
    for (int i = 0; i < size; i++) {
      queueWithMax.offer(num[i]);
    }
    for (int i = size; i < num.length; i++) {
      maxList.add(queueWithMax.getMax());
      queueWithMax.offer(num[i]);
      queueWithMax.poll();
    }
    maxList.add(queueWithMax.getMax());
    return maxList;
  }

  private class QueueWithMax {
    private int currentIndex;
    private Deque<InternalData> data;
    private Deque<InternalData> maximums;

    public QueueWithMax() {
      currentIndex = 0;
      data = new LinkedList<>();
      maximums = new LinkedList<>();
    }

    public void offer(int number) {
      while (!maximums.isEmpty() && number >= maximums.peekLast().number) {
        maximums.pollLast();
      }
      InternalData internalData = new InternalData();
      internalData.number = number;
      internalData.index = currentIndex;
      currentIndex++;
      data.offerLast(internalData);
      maximums.offerLast(internalData);
    }

    public void poll() {
      if (!maximums.isEmpty() && maximums.peekFirst().index == data.peekFirst().index) {
        maximums.pollFirst();
      }
      data.pollFirst();
    }

    public int getMax() {
      if (!maximums.isEmpty()) {
        return maximums.peekFirst().number;
      } else {
        return 0;
      }
    }
  }

  private class InternalData {
    int number;
    int index;
  }
}
