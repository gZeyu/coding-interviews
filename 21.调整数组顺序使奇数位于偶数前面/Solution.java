import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input;
        input = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(input));
        s.reOrderArray(input);
        System.out.println(Arrays.toString(input));
        input = new int[]{1};
        System.out.println(Arrays.toString(input));
        s.reOrderArray(input);
        System.out.println(Arrays.toString(input));
        input = new int[]{1, 1, 1, 1};
        System.out.println(Arrays.toString(input));
        s.reOrderArray(input);
        System.out.println(Arrays.toString(input));
        input = new int[]{1, 1, 1};
        System.out.println(Arrays.toString(input));
        s.reOrderArray(input);
        System.out.println(Arrays.toString(input));
        return;
    }
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            boolean isChanged = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    isChanged = true;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            if (isChanged == false) {
                break;
            }
        }
    }
}