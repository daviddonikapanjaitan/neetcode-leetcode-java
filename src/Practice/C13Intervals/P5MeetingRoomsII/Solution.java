package Practice.C13Intervals.P5MeetingRoomsII;

import java.util.List;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
         Interval one = new Interval(0, 40);
         Interval two = new Interval(5, 10);
         Interval three = new Interval(15, 20);
         List<Interval> input = List.of(one, two, three);

        // Interval one = new Interval(4, 9);
        // List<Interval> input = List.of(one);

        int result = minMeetingRooms(input);
        System.out.println(result);
    }

    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(Interval i: intervals) {
            mp.put(i.start, mp.getOrDefault(i.start, 0) + 1);
            mp.put(i.end, mp.getOrDefault(i.end, 0) - 1);
        }
        int prev = 0;
        int res = 0;
        for(int key: mp.keySet()) {
            prev += mp.get(key);
            res = Math.max(res, prev);
        }
        return res;
    }

    public static class Interval{
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
