import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>(2);
        int n = A.length();
        boolean flag = true;
        
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') { 
                arr.add(1);
                flag = false;
            } else {
                arr.add(-1);
            }
        }
        
        if (flag) return ans;
        
        int currSum = 0;
        int maxSum = 0;
        int left = 0;
        int right = 0;
        int bestLeft = 0;
        int bestRight = 0;
        
        for (int i = 0; i < n; i++) {
            currSum += arr.get(i);
            
            if (currSum > maxSum) {
                maxSum = currSum;
                bestLeft = left;
                bestRight = right = i;
            }
            
            if (currSum < 0) {
                currSum = 0;
                left = i + 1;
            }
        }
        
        ans.add(bestLeft + 1);
        ans.add(bestRight + 1);
        
        return ans;
    }
}
