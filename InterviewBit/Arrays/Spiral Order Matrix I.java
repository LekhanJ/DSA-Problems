import java.util.ArrayList;
import java.util.List;

class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = m - 1;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while (top <= bottom && left <= right) {
            for (int i=left; i<=right; i++) {
                ans.add(A.get(top).get(i));
            }
            top++;
            
            for (int i=top; i<=bottom; i++) {
                ans.add(A.get(i).get(right));
            }
            right--;
            
            if (top <= bottom) {
                for (int i=right; i>=left; i--) {
                    ans.add(A.get(bottom).get(i));
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i=bottom; i>=top; i--) {
                    ans.add(A.get(i).get(left));
                }
                left++;
            }
        }
        
        return ans;
    }
}

