public class Solution {
    int count = 0;

    public static void main(String[] args) {
        Solution s = new Solution();
        s.print1ToMaxOfDigits(3);
    }

    public void print1ToMaxOfDigits(int n) {
        int[] number = new int[n];
        for (int i = 0; i < 10; i++) {
            number[0] = i;
            print1ToMaxOfDigitsCore(number, 1);
        }
    }

    public void print1ToMaxOfDigitsCore(int[] number, int index) {
        if (index >= number.length) {
            System.out.println(numberArrayToString(number));
            count++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = i;
            print1ToMaxOfDigitsCore(number, index + 1);
        }
    }

    public String numberArrayToString(int[] number){
        StringBuilder builder = new StringBuilder();
        int length = number.length;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == 0) {
                length--;
            }
            else {
                break;
            }
        }
        if (length == 0) {
            return "0";
        }
        for(int i = number.length - length; i < number.length; i++) {
            builder.append(number[i]);
        }
        return builder.toString();
    }

}