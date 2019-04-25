
/**
 * Created by ganjun on 2017/5/3.
 */

import java.util.*;

public class BFPRT {
    public final int MAXN = 100000;

    public static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static void sort(int[] x, int l, int r) {
        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                if (x[j] < x[i])
                    swap(x, i, j);
            }
        }
    }

    public int findMedian(int[] x, int l, int r) {
        int i, index;
        for (i = l, index = 0; i + 4 <= r; i += 5, index++) {
            sort(x, i, i + 4);
            swap(x, l + index, i + 2);
        }
        // 处理5个一分组多余的数字
        if (i <= r) {
            sort(x, i, r);
            swap(x, l + index, i + (r - i + 1) / 2);
            index++;
        }
        if (index == 1)
            return x[l + index];
        else
            return findMedian(x, l, l + index - 1);
    }

    // 寻找x数组中[l,r]区间内第k小元素
    public int findKthMin(int[] x, int l, int r, int k) {
        int median = findMedian(x, l, r);
        // 类似快速排序的方式，确定一个pivot为这个中位数的值x[l]，然后小的数放左边，大的数放右边
        // 填坑法，最开始的数字x[l]上l位置是空出来的，
        // 那么每一轮都从右边位置j找到一个较小的数填到i上（最开始i=l)，然后i上空出来了位置，
        // 就再从左侧开始找到一个较大的数填回j上，直到i>=j
        int mediemVal = x[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && x[j] > mediemVal)
                j--;
            if (i < j)
                x[i] = x[j];
            while (i < j && x[i] < mediemVal)
                i++;
            if (i < j)
                x[j] = x[i];
        }
        x[i] = mediemVal;
        if (i - l + 1 == k)
            return x[i];
        else if (i - l + 1 > k)
            return findKthMin(x, l, i - 1, k);
        else
            return findKthMin(x, i + 1, r, k - (i - l + 1));
    }

    public static void main(String[] args) {

        int[] x = { 2, 3, 6, 5, 7, 9, 4 };
        BFPRT sol = new BFPRT();
        // int val = sol.findMidiem(x , 0 , 6);
        int val = sol.findKthMin(x, 0, x.length - 1, 4);
        System.out.println(val);
    }
}

// import java.util.Arrays;

// public class Solution {
// public static void main(String[] args) {
// Solution s = new Solution();
// int[] array;
// array = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
// System.out.println(s.MoreThanHalfNum_Solution(array));
// array = new int[] { 0, 1, 2, 4, 5, 6, 3 };
// System.out.println(s.partition(array, 0, array.length - 1));
// System.out.println(Arrays.toString(array));
// array = new int[] { 5, 4, 3, 2, 1 };
// System.out.println(s.insertionSort(array, 0, array.length - 1));
// System.out.println(Arrays.toString(array));
// }

// public int MoreThanHalfNum_Solution(int[] array) {
// return select(array, 0, array.length - 1, (array.length - 1) >> 1);
// }

// private int partition(int[] array, int left, int right) {
// int pivot = array[right];
// int i = left - 1;
// for (int j = left; j < right; j++) {
// if (array[j] <= pivot) {
// i++;
// swap(array, i, j);
// }
// }
// swap(array, i + 1, right);
// return i + 1;
// }

// private int insertionSort(int[] array, int left, int right) {
// for (int j = 0; j <= right; j++) {
// int key = array[j];
// int i = j - 1;
// while (i >= 0 && array[i] > key) {
// swap(array, i + 1, i);
// i--;
// }
// array[i + 1] = key;
// }
// return (left + right) >> 1;
// }

// private void swap(int[] array, int i, int j) {
// int tmp = array[i];
// array[i] = array[j];
// array[j] = tmp;
// }

// private int pivot(int[] array, int left, int right) {
// if (right - left < 5) {
// return insertionSort(array, left, right);
// }
// int subLeft = left;
// int boundOfMedians = right;
// while (subLeft <= right) {
// int subRight = subLeft + 4;
// if (subRight > left) {
// subRight = right;
// }
// int medianIndex = insertionSort(array, subLeft, subRight);
// boundOfMedians = (subLeft - left) / 5;
// swap(array, medianIndex, boundOfMedians);
// subLeft = subLeft + 5;
// }
// return pivot(array, left, boundOfMedians);
// }

// private int select(int[] array, int left, int right, int kth) {
// while (true) {
// if (left == right) {
// return left;
// }
// int medianOfmediansIndex = pivot(array, left, right);
// swap(array, medianOfmediansIndex, right);
// int pivotIndex = partition(array, left, right);
// if (kth == pivotIndex) {
// return kth;
// } else if (kth < pivotIndex) {
// right = pivotIndex - 1;
// } else {
// left = pivotIndex + 1;
// }
// }
// }
// }
