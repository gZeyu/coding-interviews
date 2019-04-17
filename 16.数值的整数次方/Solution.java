import static java.lang.Math.abs;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Power(2, -3));
    }

    public double Power(double base, int exponent) {
        if (abs(base) < 0.0000001 && exponent < 0) {
            return 0.0;
        }
        if (exponent > 0) {
            return PowerWithUnsignedExponent(base, exponent);
        } else {
            return 1.0 / PowerWithUnsignedExponent(base, -exponent);
        }
    }

    public double PowerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        int ex = exponent;
        double result = base;
        while (ex > 1) {
            result *= result;
            ex >>= 1;
        }
        if (ex > 0) {
            result *= base;
        }
        return result;
    }
}