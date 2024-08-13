import java.util.ArrayList;

class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int count = 0;
        
        for (int i=0; i<n; i++) {
            int left = Math.max(i-B+1, 0);
            int right = Math.min(i+B-1, n-1);
            boolean bulbFound = false;
            while (right >= left) {
                if (A.get(right) == 1) {
                    bulbFound = true;
                    break;
                }
                right--;
            }
            
            if (!bulbFound) return -1;
            
            count++;
            
            i = right + B;
        }
        
        return count;
    }
}
