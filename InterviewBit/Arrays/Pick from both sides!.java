import java.util.ArrayList;

class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A.get(i);
        }
        
        int maxSum = sum;

        for (int i = 1; i <= B; i++) {
            sum = sum - A.get(B - i) + A.get(n - i);
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}

