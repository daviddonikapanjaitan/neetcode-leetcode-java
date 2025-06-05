package C13Intervals.P4MeetingRooms;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        Interval one = new Interval(0, 30);
        Interval two = new Interval(5, 10);
        Interval three = new Interval(15, 20);
        List<Interval> input = List.of(one, two, three);

        // Interval one = new Interval(5, 8);
        // Interval two = new Interval(9, 15);
        // List<Interval> input = List.of(one, two);

        boolean result = canAttendMeetings(input);
        System.out.println(result);
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        for (int i = 0; i < n; i++) {
            Interval A = intervals.get(i);
            for (int j = i + 1; j < n; j++) {
                Interval B = intervals.get(j);
                if (Math.min(A.end, B.end) > Math.max(A.start, B.start)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Interval{
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
