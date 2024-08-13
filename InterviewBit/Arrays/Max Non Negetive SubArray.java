import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long temp = 0;
        long maxSum = 0;
        ArrayList<Integer> tempArr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                temp += A.get(i);
                tempArr.add(A.get(i));
            } else {
                if (temp >= maxSum) {
                    maxSum = temp;
                    ans = new ArrayList<>(tempArr);
                }
                temp = 0;
                tempArr.clear();
            }
        }
        
        if (temp > maxSum) {
            ans = new ArrayList<>(tempArr);
        }
        
        return ans;
    }
}