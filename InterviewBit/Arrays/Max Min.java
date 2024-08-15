import java.util.ArrayList;

class Solution {
    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<A.size(); i++) {
            if (A.get(i) > max) max = A.get(i);
            if (A.get(i) < min) min = A.get(i);
        }
        
        return (max+min);
    }
}
