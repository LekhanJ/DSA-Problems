import java.util.ArrayList;

class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int steps = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            int dx = Math.abs(A.get(i + 1) - A.get(i));
            int dy = Math.abs(B.get(i + 1) - B.get(i));
            steps += Math.max(dx, dy);
        }
        return steps;
    }
}
