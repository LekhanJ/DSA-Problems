class Solution {
    public int maxArr(int[] A) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        // Traverse through the list
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            max1 = Math.max(max1, value + i);
            min1 = Math.min(min1, value + i);
            
            max2 = Math.max(max2, value - i);
            min2 = Math.min(min2, value - i);
        }
        
        // Calculate the result
        int ans = Math.max(max2 - min2, max1 - min1);
        
        return ans;
    }
}
