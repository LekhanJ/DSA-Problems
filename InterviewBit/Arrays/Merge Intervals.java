import java.util.ArrayList;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        ArrayList<Interval> ans = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;
        boolean check = false;

        for (int i=0; i<n; i++) {
            if (intervals.get(i).end < start) ans.add(intervals.get(i));
            else if (intervals.get(i).start > end) {
                if (!check) ans.add(new Interval(start, end));
                ans.add(intervals.get(i));
                check = true;
            }
            else {
                start = Math.min(start, intervals.get(i).start);
                end = Math.max(end, intervals.get(i).end);
            }
        }

        if (!check) {
            ans.add(new Interval(start, end));
        }
        return ans;
    }
}
