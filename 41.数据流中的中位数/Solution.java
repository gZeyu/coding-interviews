import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution s;
        s = new Solution();
        for (int num : new int[] { 3, 2, 4, 1, 5 }) {
            s.Insert(num);
        }
        System.out.println(s.GetMedian());
        s = new Solution();
        for (int num : new int[] { 1 }) {
            s.Insert(num);
        }
        System.out.println(s.GetMedian());
        s = new Solution();
        for (int num : new int[] { 2, 1 }) {
            s.Insert(num);
        }
        System.out.println(s.GetMedian());
        s = new Solution();
        for (int num : new int[] {}) {
            s.Insert(num);
        }
        System.out.println(s.GetMedian());
    }

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
        return o2 - o1;
    });
    private PriorityQueue<Integer> minHeap;

    public Solution() {
        minHeap = new PriorityQueue<>();
    }

    public void Insert(Integer num) {
        if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            if (minHeap.size() > 0 && minHeap.peek() < num) {
                maxHeap.offer(minHeap.peek());
                minHeap.poll();
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (maxHeap.size() > 0 && maxHeap.peek() > num) {
                minHeap.offer(maxHeap.peek());
                maxHeap.poll();
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    public Double GetMedian() {
        if (maxHeap.size() + minHeap.size() == 0) {
            return 0.0;
        } else if (((maxHeap.size() + minHeap.size()) & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek() / 1.0;
        }
    }
}
