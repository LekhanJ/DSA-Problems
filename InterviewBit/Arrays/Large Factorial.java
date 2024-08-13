import java.math.BigInteger;

class Solution {
    public static String solve(int A) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = A; i>0; i--) {
            factorial = factorial.multiply((BigInteger.valueOf(i))); 
        }
        return factorial.toString();
    }
}
