import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] right = new int[n];
        
        // Fill the right array
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                right[i] = A.get(i);
            } else {
                right[i] = Math.max(right[i + 1], A.get(i));
            }
        }
        
        // Using a TreeSet to maintain a sorted set of elements
        TreeSet<Integer> s = new TreeSet<>();
        s.add(A.get(0));
        int ans = 0;
        
        // Traverse the array to compute the answer
        for (int i = 1; i < n; i++) {
            s.add(A.get(i));
            Integer current = A.get(i);
            Integer lower = s.lower(current); // Get the largest element less than current
            
            if (lower != null && right[i] != current) {
                ans = Math.max(ans, lower + current + right[i]);
            }
        }
        
        return ans;
    }
}
