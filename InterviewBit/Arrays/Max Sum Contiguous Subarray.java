import java.util.List;

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int n = A.size();
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        for (int i = 0; i < n; i++) {
            currSum += A.get(i);
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        
        return maxSum;
    }
}
