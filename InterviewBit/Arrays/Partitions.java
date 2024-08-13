import java.util.ArrayList;

class Solution {
    public int solve(int A, ArrayList<Integer> B) {
        int ans = 0;
        long totalSum = 0;
        int[] suffixPartCount = new int[A];
        
        // Calculate total sum of the array
        for (int i = 0; i < A; i++) {
            totalSum += B.get(i);
        }
        
        // If total sum is not divisible by 3, return 0
        if (totalSum % 3 != 0) {
            return ans;
        }
        
        long partSum = totalSum / 3;
        long localSum = 0;
        
        // Fill suffixPartCount array
        for (int i = A - 1; i >= 0; i--) {
            localSum += B.get(i);
            if (localSum == partSum) {
                suffixPartCount[i] = 1;
            }
        }
        
        // Calculate suffix sums
        for (int i = A - 2; i >= 0; i--) {
            suffixPartCount[i] += suffixPartCount[i + 1];
        }
        
        localSum = 0;
        // Count the number of ways to partition the array
        for (int i = 0; i + 2 < A; i++) {
            localSum += B.get(i);
            if (localSum == partSum) {
                ans += suffixPartCount[i + 2];
            }
        }
        
        return ans;
    }
}
