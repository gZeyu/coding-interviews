import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.VerifySquenceOfBST(new int[] { 5, 7, 6, 9, 11, 10, 8 }));
        System.out.println(s.VerifySquenceOfBST(new int[] { 7, 4, 6, 5 }));

        return;
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 1) {
            return true;
        }
        if (sequence.length == 0) { // input:[], output:false
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int startOfRight = length - 1;
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] > root) {
                startOfRight = i;
                break;
            }
        }
        for (int i = startOfRight; i < length - 1; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        int[] left = startOfRight > 0 ? Arrays.copyOfRange(sequence, 0, startOfRight) : null;
        int[] right = startOfRight < length - 1 ? Arrays.copyOfRange(sequence, startOfRight, length - 1) : null;

        return VerifySquenceOfBST(left) && VerifySquenceOfBST(right);
    }

}

    

    
        



    
        
    