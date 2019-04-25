public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.FindGreatestSumOfSubArray(new int[] { 1, -2, 3, 10, -4, 7, 2, -5 }));
        System.out.println(s.FindGreatestSumOfSubArray(new int[] { -2, -8, -1, -5, -9 }));
        System.out.println(s.FindGreatestSumOfSubArray(new int[] {}));
        System.out.println(s.FindGreatestSumOfSubArray(null));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            max = sum > max ? sum : max;
        }
        return max;
    }
}
