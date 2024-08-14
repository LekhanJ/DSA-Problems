import java.util.Map;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solve(List<String> A) {
        int rows = A.size();
        int cols = A.get(0).length();
        
        // Array of HashMaps to store maxRow and minRow values for each column
        Map<Character, Integer>[] maxRow = new HashMap[cols];
        Map<Character, Integer>[] minRow = new HashMap[cols];
        
        for (int j = 0; j < cols; j++) {
            maxRow[j] = new HashMap<>();
            minRow[j] = new HashMap<>();
        }
        
        // HashMaps to store maxCol and minCol values for the entire grid
        Map<Character, Integer> maxCol = new HashMap<>();
        Map<Character, Integer> minCol = new HashMap<>();
        
        // Populate maxRow, minRow, maxCol, and minCol maps
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = A.get(i).charAt(j);
                
                // Update maxRow and minRow for each character in the current column
                maxRow[j].put(ch, Math.max(maxRow[j].getOrDefault(ch, i), i));
                minRow[j].put(ch, Math.min(minRow[j].getOrDefault(ch, i), i));
                
                // Update maxCol and minCol for each character in the entire grid
                maxCol.put(ch, Math.max(maxCol.getOrDefault(ch, j), j));
                minCol.put(ch, Math.min(minCol.getOrDefault(ch, j), j));
            }
        }
        
        int ans = 0;
        
        // Iterate through each column to find the maximum area
        for (int col = 0; col < cols; col++) {
            int maxBase, maxHeight;
            
            // R, G as base vertices and B as third vertex
            if (maxRow[col].containsKey('r') && maxRow[col].containsKey('g') && maxCol.containsKey('b')) {
                maxBase = Math.max(Math.abs(maxRow[col].get('r') - minRow[col].get('g')),
                                   Math.abs(minRow[col].get('r') - maxRow[col].get('g'))) + 1;
                maxHeight = Math.max(Math.abs(col - maxCol.get('b')),
                                     Math.abs(col - minCol.get('b'))) + 1;
                ans = Math.max(ans, maxBase * maxHeight);
            }
            
            // G, B as base vertices and R as third vertex
            if (maxRow[col].containsKey('g') && maxRow[col].containsKey('b') && maxCol.containsKey('r')) {
                maxBase = Math.max(Math.abs(maxRow[col].get('g') - minRow[col].get('b')),
                                   Math.abs(minRow[col].get('g') - maxRow[col].get('b'))) + 1;
                maxHeight = Math.max(Math.abs(col - maxCol.get('r')),
                                     Math.abs(col - minCol.get('r'))) + 1;
                ans = Math.max(ans, maxBase * maxHeight);
            }
            
            // B, R as base vertices and G as third vertex
            if (maxRow[col].containsKey('b') && maxRow[col].containsKey('r') && maxCol.containsKey('g')) {
                maxBase = Math.max(Math.abs(maxRow[col].get('b') - minRow[col].get('r')),
                                   Math.abs(minRow[col].get('b') - maxRow[col].get('r'))) + 1;
                maxHeight = Math.max(Math.abs(col - maxCol.get('g')),
                                     Math.abs(col - minCol.get('g'))) + 1;
                ans = Math.max(ans, maxBase * maxHeight);
            }
        }
        
        return (int) Math.ceil(ans / 2.0);
    }
}
