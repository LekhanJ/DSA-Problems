import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        int carry = 0;
        int rem = 0;
        ArrayList<Integer> ans = new ArrayList<>(A);
        
        // Increment the last element
        ans.set(n - 1, ans.get(n - 1) + 1);
        
        // Traverse from the end to the beginning
        for (int i = n - 1; i > 0; i--) {
            carry = ans.get(i) / 10;
            rem = ans.get(i) % 10;
            ans.set(i, rem);
            ans.set(i - 1, ans.get(i - 1) + carry);
        }
        
        // Handle the case where the first element might be greater than 10
        if (ans.get(0) >= 10) {
            ans.set(0, ans.get(0) % 10);
            ans.add(0, 1);
        }
        
        // Remove leading zeros
        while (ans.size() > 1 && ans.get(0) == 0) {
            ans.remove(0);
        }
        
        return ans;
    }
}
